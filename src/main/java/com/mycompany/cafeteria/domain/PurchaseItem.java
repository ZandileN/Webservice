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
public class PurchaseItem implements Serializable{
    private String name;
    private int qaunt;
    
    private PurchaseItem(){
        
    }
    
    private PurchaseItem(Builder build){
         
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
     public PurchaseItem build(){
       return new PurchaseItem(this);
       } 
    public Builder copy(PurchaseItem order){
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