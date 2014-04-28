/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
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
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int hoursOpen;
    private String tel;
    @Embedded
    Help help;
    @OneToMany
    @JoinColumn(name="store_id")
    Supplier supplier;
    @OneToMany
    @JoinColumn(name="store__id")
    Customer customer;
    
    private Store(Builder builder) {
        id = builder.id;
        name = builder.name;
        hoursOpen = builder.hoursOpen;
        tel= builder.tel;
        supplier=builder.supplier;
    }
     private Store() {
    }

    public static class Builder {

        private long id;
        private String name;
        private int hoursOpen;
        private String tel;
        private Supplier supplier;
        public Builder name(String value) {
            name = value;
            return this;
        }
          public Builder hoursOpen(int value) {
            hoursOpen = value;
            return this;
        }
            public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder tel(String value){
            tel=value;
            return this;
       }
        public Builder supplier(Supplier value){
         supplier=value;
         return this;
        }
         
        public Store build(){
            return new Store(this);
        }
        public Builder copy(Store store){
            this.name=store.name;
            this.hoursOpen=store.hoursOpen;
            this.tel=store.tel;
            this.supplier=store.supplier;
            return this;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getHoursOpen() {
        return hoursOpen;
    }

    public String getTel() {
        return tel;
    }

    public Help getHelp() {
        return help;
    }

    public Supplier getSuppier() {
        return supplier;
    }

    public Customer getCustomer() {
        return customer;
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
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.Store[ id=" + id + " ]";
    }
    
}
