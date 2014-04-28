/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import java.util.Locale.Builder;
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
public class FoodCatergory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    
    @Embedded
    private MainMeal meal;
    @Embedded
    private FruitandVegetable fruitveg;
    @Embedded
    private Beverages beverages;
    @Embedded
    private DairyFoods dairy;
    //@OneToMany
    //@JoinColumn(name="foodcat_id")
    //List<Account> accounts;
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="foodcat_id")
    private FoodCatergory(Builder builder) {
        id = builder.id;
        type = builder.type;
        meal = builder.meal;
        //fruitveg=builder.fruitveg;
        
    }

    private FoodCatergory() {
    }

    public static class Builder {

        private long id;
        private String type;
        private MainMeal meal;
        private FruitandVegetable fruitveg;
        private Beverages beverages;
        private DairyFoods dairy;
       // private Contact contact;
        
        public Builder type(String value) {
            type = value;
            return this;
        }
          public Builder meal(MainMeal value) {
            meal = value;
            return this;
        }
            public Builder fruitandVeg(FruitandVegetable value) {
            fruitveg = value;
            return this;
        }
          
         public Builder Beverages(Beverages value) {
            beverages = value;
            return this;
        }
           public Builder dairy(DairyFoods value) {
            dairy = value;
            return this;
        }
          
          
            public Builder id(Long value) {
            id = value;
            return this;
        }
       
        public Builder copy(FoodCatergory cat){
           id = cat.getId();
           meal= cat.getMeal();
           fruitveg=cat.getFruitveg();
           beverages= cat.getBeverages();
           dairy=cat.getDairy();
           
           
            return this;
        }
          
        public FoodCatergory build(){
            return new FoodCatergory(this);
        }
    }

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public MainMeal getMeal() {
        return meal;
    }

    public FruitandVegetable getFruitveg() {
        return fruitveg;
    }

    public Beverages getBeverages() {
        return beverages;
    }

    public DairyFoods getDairy() {
        return dairy;
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
        if (!(object instanceof FoodCatergory)) {
            return false;
        }
        FoodCatergory other = (FoodCatergory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cafeteria.domain.FoodCatergory[ id=" + id + " ]";
    }
}
