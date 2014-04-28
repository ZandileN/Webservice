/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;

/**
 *
 * @author Sibakhulu
 */
public class Starters implements Serializable{
    private String name;
    private String type;
    private double price;
 
   private Starters(Builder builder) {
        name = builder.name;
        type = builder.type;
        price= builder.price;
    }

    private Starters() {
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
         public Starters build(){
         return  new Starters(this);
         }
         public Builder copy(Starters st){
          this.name=st.name;
          this.price=st.price;
          this.type=st.type;
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
    
    
}
