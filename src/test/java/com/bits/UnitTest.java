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
public class UnitTest {
    @Test
    public void testValidUnit() {
        Unit unit = new Unit("kg", "Kilogram");
        assertEquals(unit.getCode(), "kg");
        assertEquals(unit.getName(), "Kilogram");
    }
    
    @Test
    public void testInvalidUnit() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Unit("abcd", "Some unit")
        );
        assertEquals("The code abcd is invalid.", exception.getMessage());
    }
    
    @Test
    public void testSetValidCode() {
        Unit unit = new Unit();
        unit.setCode("kg");
        assertEquals(unit.getCode(), "kg");
    }
    
    @Test
    public void testSetInvalidCode() {
        Unit unit = new Unit();
        Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> unit.setCode("abcd")    
        );
        assertEquals("The code abcd is invalid.", exception.getMessage());
    }
    
    @Test
    public void testGetByCodeWithValidCode() {
        Unit unit = Unit.getByCode("kg");
        assertEquals(unit.getCode(), "kg");
        assertEquals(unit.getName(), "Kilogram");
    }

}
