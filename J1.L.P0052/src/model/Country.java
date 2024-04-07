/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    protected String terrain;

    public Country() {
    }
    
    public void printf() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        System.out.printf("%-20s%-20s%-20s%-20s\n", countryCode, countryName, totalArea*1.0,terrain);
    }
    public Country(String countryCode, String countryName, float totalArea,String terrain) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
        this.terrain = terrain;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    
   
    public void print() {
        System.out.printf("%-20s%-20s%-20s%-20s\n", countryCode, countryName, totalArea*1.0,terrain);
    }
             
}
