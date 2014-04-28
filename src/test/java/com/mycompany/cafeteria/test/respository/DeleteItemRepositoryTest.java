/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.DeleteItem;
import com.mycompany.cafeteria.repository.DeleteItemRepository;
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
public class DeleteItemRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private DeleteItemRepository repo;
    
    public DeleteItemRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void CreateDeleteItem() {
      repo = ctx.getBean(DeleteItemRepository.class);
         DeleteItem ditem = new DeleteItem.Builder().name("Ice tea").build();        
         repo.save(ditem);
          //id = ditem.getId();
         Assert.assertNotNull(ditem);
     }
     
      @Test(dependsOnMethods = "createDeleteItem")
     public void readPerson(){
         repo = ctx.getBean(DeleteItemRepository.class);
         DeleteItem person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Ice tea");
         
     }
       @Test(dependsOnMethods = "readDeleteItem")
     private void updateDeleteItem(){
         repo = ctx.getBean(DeleteItemRepository.class);
         DeleteItem person = repo.findOne(id);
         DeleteItem updateddelete = new DeleteItem.Builder().name("Ice tea")
                                                            .build();
        
         repo.save(updateddelete);
         
         DeleteItem newPerson = repo.findOne(id);
         Assert.assertEquals(newPerson.getName(), "Ice tea");
         
     }
      @Test(dependsOnMethods = "updateDeleteItem")
     private void deletePerson(){
         repo = ctx.getBean(DeleteItemRepository.class);
         DeleteItem item = repo.findOne(id);
         repo.delete(item);
         
         DeleteItem deletedItem = repo.findOne(id);
         Assert.assertNull(deletedItem);   
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