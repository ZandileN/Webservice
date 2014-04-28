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
public class Address implements Serializable{
    private String street;
    private String city;
    private int postalCode;
    private String email;

     private Address(Builder builder) {
        street = builder.street;
        city = builder.city;
        postalCode = builder.postalCode;
        email=builder.email; 
    }

    private Address() {
    }

    public static class Builder {

        private String street;
        private String city;
        private int  postalCode;
        private String email;

        public Builder Street(String value) {
            street = value;
            return this;
        }
          public Builder city(String value) {
            city = value;
            return this;
        }
            public Builder postalCode(int value) {
            postalCode = value;
            return this;
        }
           public Builder email(String value) {
            email = value;
            return this;
        }
        public Address build(){
            return new Address(this);
        }
        public Builder copy(Address ad){
            this.street= ad.street;
            this.city=ad.city;
            this.postalCode=ad.postalCode;
            this.email=ad.email;
            return this;
        }
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.postalCode;
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
        final Address other = (Address) obj;
        if (this.postalCode != other.postalCode) {
            return false;
        }
        return true;
    }
    
    
}
