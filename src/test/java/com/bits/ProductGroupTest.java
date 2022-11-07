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
public class ProductGroupTest {
    
    @Test
    public void testValidProductGroup() {
        ProductGroup productGroup = new ProductGroup("kg", "Kilogram");
        assertEquals(productGroup.getCode(), "kg");
        assertEquals(productGroup.getName(), "Kilogram");
    }
    
    @Test
    public void testInvalidProductGroup() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ProductGroup("abcd", "Some unit")
        );
        assertEquals("The code abcd is invalid.", exception.getMessage());
    }
    
    @Test
    public void testSetValidCode() {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setCode("kg");
        assertEquals(productGroup.getCode(), "kg");
    }
    
    @Test
    public void testSetInvalidCode() {
        ProductGroup productGroup = new ProductGroup();
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> productGroup.setCode("abcd")    
        );
        assertEquals("The code abcd is invalid.", exception.getMessage());
    }
}
