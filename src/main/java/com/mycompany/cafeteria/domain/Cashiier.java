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
public class Cashiier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    
    
     private Cashiier(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        lastname=builder.lastname;
    }
     private Cashiier() {
    }

    public static class Builder {

        private long id;
        private String firstname;
        private String lastname;
        
        public Builder name(String value) {
            firstname = value;
            return this;
        }
        public Builder lastname(String value){
          lastname= value;
          return this;
        } 
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
         
        public Cashiier build(){
            return new Cashiier(this);
        }
        public Builder copy(Cashiier cashier){
            this.id=cashier.id;
            this.firstname=cashier.firstname;
            this.lastname=cashier.lastname;
            return this;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getfirstname() {
        return firstname;
    }
    public String getlastname(){
        return lastname;
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
        if (!(object instanceof Cashiier)) {
            return false;
        }
        Cashiier other = (Cashiier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.Cashiier[ id=" + id + " ]";
    }
    
}

