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
public class OrderItem implements Serializable{
    private String name;
    private int qaunt;
    
    private OrderItem(Builder build){
         
         name=build.name;
         qaunt=build.qaunt;
        
}
   public static class Builder{
       private String name;
       private int qaunt;
      
    public Builder name(String value){
        name= value;
        return this;
    }
    public Builder qaunt(int value){
        qaunt= value;
        return this;
    }
     public OrderItem build(){
       return new OrderItem(this);
       } 
    public Builder copy(OrderItem order){
        this.name=order.name;
        this.qaunt=order.qaunt;
        return this;   
}
    
   }

    public String getName() {
        return name;
    }

    public int getQaunt() {
        return qaunt;
    }
   
}
