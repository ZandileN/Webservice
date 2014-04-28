/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.Store;
import com.mycompany.cafeteria.repository.StoreRepository;
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
public class StoreRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private StoreRepository repo;
    
    public StoreRepositoryTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createStore(){
     repo = ctx.getBean(StoreRepository.class);
     Store store= new Store.Builder().id(id).name("NgxumzaTechnologies")
                                            .hoursOpen(8)
                                            .tel("0216879994")
                                            .supplier(null).build();  
         repo.save(store);
         id = store.getId();
         Assert.assertNotNull(store);
     }
     
     @Test(dependsOnMethods = "createStore")
     public void readStore(){
      repo = ctx.getBean(StoreRepository.class);
      
       Store store = repo.findOne(id);
       Assert.assertEquals(store.getTel(), "0216879994");   
     }
     @Test(dependsOnMethods = "readStore")
     private void updatePerson(){
         repo = ctx.getBean(StoreRepository.class);
         Store store = repo.findOne(id);
         store.getTel();
         repo.save(store);
         
         Store updatePerson = repo.findOne(id);   
         Assert.assertEquals(updatePerson.getTel(), "Boniface");
         
     }
      @Test(dependsOnMethods = "updatePerson")
     private void deleteStore(){
         repo = ctx.getBean(StoreRepository.class);
         Store store = repo.findOne(id);
         repo.delete(store);
         
         Store deletedStore = repo.findOne(id);
         
         Assert.assertNull(deletedStore);    
     }
    //@Autowired
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