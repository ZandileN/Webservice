/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.Cashiier;
import com.mycompany.cafeteria.repository.CashiierRepository;
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
public class CashiierRepositoryTest {
     public static ApplicationContext ctx;
    private Long id;

    private CashiierRepository repo;
    
    public CashiierRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCashiier() {
      repo= ctx.getBean(CashiierRepository.class);
      Cashiier cashier= new Cashiier.Builder().id(id)
                                              .name("Veronica")
                                              .lastname("Jacobs").build();
      
        repo.save(cashier);
      Assert.assertNotNull(cashier);
     }
     
     @Test(dependsOnMethods = "readCashiier")
     public void readCashiier(){
     repo = ctx.getBean(CashiierRepository.class);
         Cashiier cashier = repo.findOne(id);
         Assert.assertEquals(cashier.getfirstname(), "Veronica");
     }
     
     @Test(dependsOnMethods = "createCashiier")
     public void updateCashiier(){
         repo = ctx.getBean(CashiierRepository.class);
         Cashiier cashier = repo.findOne(id);
         cashier.getfirstname();
         repo.save(cashier);
         
         Cashiier updateCashier = repo.findOne(id);
         Assert.assertEquals(updateCashier.getfirstname(), "Boniface");
     }
     
     @Test(dependsOnMethods = "updateCashiier")
     private void deletePerson(){
         repo = ctx.getBean(CashiierRepository.class);
         Cashiier cashier = repo.findOne(id);
         repo.delete(cashier);
         
         Cashiier deletedcashier = repo.findOne(id);
         
         Assert.assertNull(deletedcashier);    
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