/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.PurchaseItem;
import com.mycompany.cafeteria.repository.PurchaseItemRepository;
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
public class PurchaseItemRepositoryTest {
    
     public static ApplicationContext ctx;
    private Long id;

    private PurchaseItemRepository repo;
    
    
    public PurchaseItemRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void CreatePurchaseItem() {
     repo = ctx.getBean(PurchaseItemRepository.class);
         PurchaseItem p = new PurchaseItem.Builder().name("Yoghurt")
                                                    .qaunt(2).build();
         repo.save(p);
         //id = p.getId();
         Assert.assertNotNull(p);
     }
  @Test(dependsOnMethods = "createPurchaseItem")
     public void readPerson(){
         repo = ctx.getBean(PurchaseItemRepository.class);
         PurchaseItem p = repo.findOne(id);
         Assert.assertEquals(p, "Yoghurt");
     }
   @Test(dependsOnMethods = "readPurchaseItem")
     private void updatePerson(){
         repo = ctx.getBean(PurchaseItemRepository.class);
         PurchaseItem person = repo.findOne(id);
         PurchaseItem updatedPurchase = new PurchaseItem.Builder()
                                                      .name("Yoghurt")
                                                     .build();
        
         repo.save(updatedPurchase);
         
         PurchaseItem newPerson = repo.findOne(id);
         Assert.assertEquals(newPerson.getName(), "Mint Chocolate");
         
     }
     @Test(dependsOnMethods = "updatePerson")
     private void deletePerson(){
         repo = ctx.getBean(PurchaseItemRepository.class);
         PurchaseItem p = repo.findOne(id);
         repo.delete(p);
         PurchaseItem deletedPurchase = repo.findOne(id);   
         Assert.assertNull(deletedPurchase); 
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