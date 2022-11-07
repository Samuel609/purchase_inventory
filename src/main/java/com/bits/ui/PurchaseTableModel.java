/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.ui;

import com.bits.Purchase;
import com.bits.Util;
import com.bits.services.PurchaseServices;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ALE
 */
public class PurchaseTableModel extends AbstractTableModel {

    List<Purchase> purchasedItem = new ArrayList<>();
    String columnNames[] = {"ID", "Product", "Date", "Quantity", "Total"};
    Class<?> columnClasses[] = {Integer.class, String.class, String.class, float.class, float.class};

    Map fieldMap = new HashMap();

    PurchaseTableModel() {
        fieldMap.put(0, "ID");
        fieldMap.put(1, "Product");
        fieldMap.put(2, "Date");
        fieldMap.put(3, "Quantity");
        fieldMap.put(4, "Total");

    }

    @Override
    public int getRowCount() {
        return purchasedItem.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var methodName = String.format("get%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(purchasedItem.get(rowIndex), methodName);
        return (Object) Util.callMethod(method, purchasedItem.get(rowIndex));
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Purchase purchase = purchasedItem.get(rowIndex);
        String column = (String) fieldMap.get(columnIndex);
        var methodName = String.format("set%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(purchasedItem.get(rowIndex), methodName, String.class);
        Util.callMethod(method, purchasedItem.get(rowIndex), aValue);

        fireTableCellUpdated(rowIndex, columnIndex);

        PurchaseServices service = new PurchaseServices();
        service.update(purchase, column, (String) aValue);
    }
}
