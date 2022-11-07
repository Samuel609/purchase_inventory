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
public class ProductTest {
    @Test
    public void testSetValidCode() {
        Product product = new Product();
        product.setCode("kg");
        assertEquals(product.getCode(), "kg");
    }
    
    @Test
    public void testSetInvalidCode() {
        Product product = new Product();
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> product.setCode("abcd")    
        );
        assertEquals("The code abcd is invalid.", exception.getMessage());
    }

    @Test
    public void testSetValidUnitPrice() {
        Product product = new Product();
        product.setUnitPrice(15.0F);
        assertEquals(product.getUnitPrice(), 15.0F);
    }
    
    @Test
    public void testSetInvalidUnitPrice() {
        Product product = new Product();
        Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> product.setUnitPrice(-4F)
        );
        assertEquals("The price -4.00 is invalid.", exception.getMessage());
    }
    
    @Test
    public void testSetValidQuantity() {
        Product product = new Product();
        product.setQuantity(15.0F);
        assertEquals(product.getQuantity(), 15.0F);
    }
    
    @Test
    public void testSetInvalidQuantity() {
        Product product = new Product();
        Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> product.setQuantity(-4F)
        );
        assertEquals("The quantity -4.00 is invalid.", exception.getMessage());
    }
}
