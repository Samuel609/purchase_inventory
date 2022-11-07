/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

/**
 *
 * @author henock
 */
public class Electronics extends Product {
    public enum ElectronicsType {
        TV,
        RADIO,
        LAPTOP
    }
    
    private String brand;
    private String specification;
    private ElectronicsType type;
    
    public Electronics() {
    }
    
    public Electronics(
        String code,
        String name,
        float unitPrice,
        float quantity,
        String brand,
        String specification,
        ElectronicsType type
    ) {
        super(
            code,
            name,
            unitPrice,
            quantity,
            Unit.getByCode("ea"),
            ProductGroup.getByCode("ELE")
        );
        this.brand = brand;
        this.specification = specification;
        this.type = type;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification the specification to set
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return the type
     */
    public ElectronicsType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ElectronicsType type) {
        this.type = type;
    }
    
    
}
