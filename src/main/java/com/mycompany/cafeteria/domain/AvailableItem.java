/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sibakhulu
 */
@Entity
public class AvailableItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    
     private AvailableItem(){
        
    }
    
    private AvailableItem(Builder build){
         
         name=build.name;
         type=build.type;
        
}
   public static class Builder{
       private String name;
       private String type;
      
    public Builder name(String value){
        name= value;
        return this;
    }
    public Builder type(String value){
        type= value;
        return this;
    }
     public AvailableItem build(){
       return new AvailableItem(this);
       } 
    public Builder copy(AvailableItem order){
        this.name=order.name;
        this.type=order.type;
        return this;   
    
}
   }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailableItem)) {
            return false;
        }
        AvailableItem other = (AvailableItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.AvailableItem[ id=" + id + " ]";
    }
    
}
