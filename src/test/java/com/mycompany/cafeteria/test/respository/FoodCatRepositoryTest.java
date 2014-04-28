/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.FoodCatergory;
import com.mycompany.cafeteria.domain.MainMeal;
import com.mycompany.cafeteria.repository.FoodCatRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sibakhulu
 */
public class FoodCatRepositoryTest {
    
    public static ApplicationContext ctx;
     private Long id;
     private FoodCatRepository repo;
    
    public FoodCatRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void CreateFoodCatergory() {
      repo = ctx.getBean(FoodCatRepository.class);
      FoodCatergory cat= new FoodCatergory.Builder().id(id).type("MainMeal").build();  
      
         repo.save(cat);
         id = cat.getId();
         Assert.assertNotNull(cat);
     }
      @Test(dependsOnMethods = "createFoodCatergory")
     public void readFoodCatergory(){
         repo = ctx.getBean(FoodCatRepository.class);
         FoodCatergory cat = repo.findOne(id);
         Assert.assertEquals(cat.getType(), "MainMeal");
     }
      
     @Test (dependsOnMethods ="createFoodCatergory")
     public void updateFoodCatergory(){
     repo= ctx.getBean(FoodCatRepository.class);
     FoodCatergory foodcat= repo.findOne(id);
     FoodCatergory updatedFoodCatergory = new FoodCatergory.Builder()
                 .copy(foodcat)
                .type("FruitandVegetable")
                 .build();
        
         repo.save(updatedFoodCatergory);
         
         FoodCatergory newCat = repo.findOne(id);
         Assert.assertEquals(newCat.getType(), "FruitandVegetable");
     }
     
     @Test (dependsOnMethods ="updateFoodCatergory")
     public void deleteFoodCatergory(){
     repo= ctx.getBean(FoodCatRepository.class);
     FoodCatergory foodcat=repo.findOne(id);
     repo.delete(foodcat);
     
     FoodCatergory deletedcategory = repo.findOne(id);
     Assert.assertNull(deletedcategory); 
     
   }
     

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}