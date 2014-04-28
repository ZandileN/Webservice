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
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double balance;
    
    private Account(Builder builder) {
        id = builder.id;
        name = builder.name;
        balance = builder.balance;
        }

    private Account() {
    }
    
    public static class Builder{
    private Long id;
    private String name;
    private double balance;

        public Builder(String name) {
            this.name = name;
        }
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
          public Builder name(String value){
            this.name = value;
            return this;
        }
        
        public Builder balance(double value){
            this.balance = value;
            return this;
        }
        
        public Account build(){
            return new Account(this);
        }
          public Builder copy(Account acc){
             this.id=acc.id;
            this.name=acc.name;
            this.balance=acc.balance;
            return this;
        }    

  
    }

    public Long getId() {
        return id;
    }
      public String getName() {
        return name;
    }

        public double getBalance() {
            return balance;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.Account[ id=" + id + " ]";
    }
    

}