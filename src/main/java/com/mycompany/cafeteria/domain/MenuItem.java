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
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Itemname;
    private String category;
    private int qaunt;
    
     private MenuItem(Builder builder) {
        id = builder.id;
        Itemname = builder.itemname;
        category = builder.category;
        qaunt=builder.qaunt;
        
    }

    private MenuItem() {
    }

    public static class Builder {

        private long id;
        private String itemname;
        private String category;
        private int qaunt;
        

        public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder itemname(String value) {
            itemname = value;
            return this;
        }
          public Builder category(String value) {
            category = value;
            return this;
        }
           public Builder quantity(String value) {
            category = value;
            return this;
        } 
            
         
        public MenuItem build(){
            return new MenuItem(this);
        }
        public Builder copy(MenuItem menu){
            this.id=menu.id;
            this.itemname=menu.Itemname;
            this.category=menu.category;
            return this;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemname() {
        return Itemname;
    }

    public String getCategory() {
        return category;
    }

    public int getQaunt() {
        return qaunt;
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
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.MenuItem[ id=" + id + " ]";
    }
    
}
