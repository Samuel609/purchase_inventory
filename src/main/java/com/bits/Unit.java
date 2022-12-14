/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author henock
 */
public class Unit extends Lookup implements Serializable {
    private int id;
    
    public Unit() {
    }
    
    public Unit(String code, String name) {
        super(code, name);
    }
    
    public Unit(int id, String code, String name) {
        super(code, name);
        this.id = id;
    }
    
    public static Unit getByCode(String code) {
        return (Unit) Lookup.getByCode(Unit.getUnits(), code);
    }
    
    public static ArrayList<Unit> getUnits() {
        Unit[] units = {
            new Unit("kg", "Kilogram"),
            new Unit("l", "Liter"),
            new Unit("g", "Gram"),
            new Unit("m", "Meter"),
            new Unit("ea", "Each")
        };
        return new ArrayList<>(Arrays.asList(units));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
