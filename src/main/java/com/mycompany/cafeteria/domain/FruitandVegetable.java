/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Sibakhulu
 */
@Embeddable
public class FruitandVegetable implements Serializable {
    private String name;
    private String type;
    private double price;

    private FruitandVegetable(){}
     private FruitandVegetable(Builder build){
         
         name=build.name;
         type=build.type;
         price=build.price;
}
   public static class Builder{
       private String name;
       private String type;
       private double price;
       
    
    public Builder name(String nam){
        name= nam;
        return this;
    }
     public Builder Type(String typ){
       type=typ;
       return this;
       }
    public Builder price(double p){
      price=p;
      return this;
    }
   
    public FruitandVegetable build(){
       return new FruitandVegetable(this);
       } 
    public Builder copy(FruitandVegetable fveg){
        this.name=fveg.name;
        this.price=fveg.price;
        this.type=fveg.type;
        return this;
        
    }}

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FruitandVegetable other = (FruitandVegetable) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

  
  
    
    
}
