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
public class MainMeal implements Serializable{
    private String name;
    private String type;
    private double price;
    
    
      private MainMeal(Builder builder) {
        name = builder.name;
        type = builder.type;
        price= builder.price;
    
    }

    private MainMeal() {
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
         public MainMeal build(){
         return  new MainMeal(this);
         }
         public Builder copy(MainMeal meal){
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
        hash = 31 * hash + (this.type != null ? this.type.hashCode() : 0);
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
        final MainMeal other = (MainMeal) obj;
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        return true;
    }
       

    
    
    
    
    
}
