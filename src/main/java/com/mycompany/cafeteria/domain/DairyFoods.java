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
public class DairyFoods implements Serializable{
   private String name;
   private String type;
   private double price;
   
    private DairyFoods(Builder builder) {
        name = builder.name;
        type = builder.type;
        price= builder.price;
    
    }

    private DairyFoods() {
    }

    public static class Builder {

        private String name;
        private String type;
        private double price;

        public Builder name(String name){
            
            return this;
        }
         public Builder type(String value) {
            type = value;
            return this;
        }
         public Builder price(double value){
          price= value;
          return this;
         }
         public DairyFoods build(){
         return  new DairyFoods(this);
         }
         public Builder copy(DairyFoods meal){
          this.name=meal.name;
          this.price=meal.price;
          this.type=meal.type;
          return this;
         } 
 }

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
        int hash = 5;
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
        final DairyFoods other = (DairyFoods) obj;
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        return true;
    }
    

    
    
    

   

   
}
