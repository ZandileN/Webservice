/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Sibakhulu
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany
    @JoinColumn
    List<Account> accounts;

    public Long getId() {
        return id;
    }

  public static class Builder {

        private long id;
        private String firstname;
        private String lastname;
        List<Account> accounts;
        
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
          public Builder accounts(List<Account> value) {
            accounts = value;
            return this;
        }
        
         
        public Customer build(){
            return new Customer();
        }
        public Builder copy(Customer cust){
            this.id=cust.id;
            this.firstname=cust.firstname;
            this.lastname=cust.lastname;
            this.accounts=cust.accounts;
            return this;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Account> getAccounts() {
        return accounts;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.Customer[ id=" + id + " ]";
    }
    
}
