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
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
     private Supplier(Builder builder) {
        id = builder.id;
        name = builder.name;
        //meal = builder.meal;
        //fruitveg=builder.fruitveg;
} 
        private Supplier() {
        }
      public static class Builder {

        private long id;
        private String name;
        //private MainMeal meal;

        public Builder name(String value) {
            name = value;
            return this;
        }
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
         
        public Supplier build(){
            return new Supplier(this);
        }
        public Builder copy(Supplier sup){
            this.id=sup.id;
            this.name=sup.name;
            //this.type=cat.
            return this;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.Supplier[ id=" + id + " ]";
    }
    
}
