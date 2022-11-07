/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import com.bits.Product;
import com.bits.ProductGroup;
import com.bits.Purchase;
import com.bits.Unit;
import com.bits.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALE
 */
public class PurchaseServices implements Serializable {

    private final String filename = "purchase.obj";

    public void buy(Purchase purchase) throws IOException {
        String sql = String.format(
        "INSERT INTO purchase(purchase_date, quantity, total_price, product_id) VALUES('%s', '%s', '%s', '%s')",
                purchase.getDate(),
                purchase.getQuantity(), 
                purchase.getTotal(), 
                purchase.getProduct().getId());
        DatabaseService service = new DatabaseService();
        System.out.println("sql executed");
        service.execute(sql);
    }
    
    public Product getProduct(int id) {
        Product product = new Product();
        String sql = String.format("SELECT * FROM product WHERE id = '%s'", id);
        DatabaseService service = new DatabaseService();
        
        try(
                Connection conn = service.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getFloat("unit_price"),
                        rs.getFloat("quantity"),
                        getUnit(rs.getInt("unit_id")),
                        getProductGroup(rs.getInt("product_group_id"))
                );                
            }
        return product;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            return product;
        }
    }

    public Unit getUnit(int id) {
        Unit unit = new Unit();
        String sql = String.format("SELECT * FROM unit WHERE id = '%s'", id);
        DatabaseService service = new DatabaseService();
        
        try(
                Connection conn = service.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()){
                unit = new Unit(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"));
            }
                
        return unit;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            return unit;
        }
    }
        
    
    public ProductGroup getProductGroup(int id) {
        ProductGroup productGroup = new ProductGroup();
        String sql = String.format("SELECT * FROM product_group WHERE id = '%s'", id);
        DatabaseService service = new DatabaseService();
        
        try(
                Connection conn = service.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()) {
                productGroup = new ProductGroup(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"));
            }
        return productGroup;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            return productGroup;
        }
    }
    
    
    public ArrayList<Purchase> getAll(){
        ArrayList<Purchase> data = new ArrayList<>();
        String sql = "SELECT * FROM purchase ORDER BY id";
        DatabaseService service = new DatabaseService();
        
        try(
                Connection conn = service.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                data.add(
                    new Purchase(
                        rs.getInt("id"),
                        getProduct(rs.getInt("product_id")),
                        rs.getDate("purchase_date"),
                        rs.getFloat("quantity"),
                        rs.getFloat("total_price")
                    )
                );
//                for (Purchase purchase: data) {
//                    System.out.println(purchase.getProduct());
//                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            return data;
        }
    }
    
    public void update(Purchase purchase, String column, String value){
        String sql = String.format(
                "UPDATE sale SET %s='%s' WHERE id=%d",
                column,
                value,
                purchase.getID()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
        
    }

    public void writeAll(List<Purchase> purchases) {
        String values = "";
        for(Purchase purchase : purchases){
            if(!values.equals("")){
                values += ",";
            }
            values += String.format("('%s', '%s', '%s', '%s')", purchase.getDate(), purchase.getQuantity(), purchase.getTotal(), purchase.getProduct().getId());
        }
        String sql = String.format("INSERT INTO purchase(purchase_date, quantity, total_price, product_id,) VALUES %s;",values);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
}
