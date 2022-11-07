/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.bits;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author henock
 */
public class ElectronicsTest {
    @Test
    public void testDefaultAssignment() {
        Electronics el = new Electronics("STV", "Samsung 8 Series", 100, 10, "Samsung",
                "55 inch", Electronics.ElectronicsType.TV);
        var unit = el.getUnit();
        var group = el.getProductGroup();
        assertEquals("ea", unit.getCode());
        assertEquals("Each", unit.getName());
        assertEquals("ELE", group.getCode());
        assertEquals("Electronics", group.getName());

    }
}
