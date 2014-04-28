/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.Customer;
import com.mycompany.cafeteria.repository.CustomerRepository;
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
public class CustomerRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private CustomerRepository repo;
    
    public CustomerRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createCustomer(){
          repo = ctx.getBean(CustomerRepository.class);
         Customer c = new Customer.Builder().id(id).name("Cindy")
                                            .lastname("Jacobs").build();
         repo.save(c);
         id = c.getId();
         Assert.assertNotNull(c);
     }
       @Test(dependsOnMethods = "createCustomer")
     public void readCustomer(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer customer = repo.findOne(id);
         Assert.assertEquals(customer.getFirstname(), "Cindy");
         
     }
       @Test(dependsOnMethods = "readCustomer")
     private void updateCustomer(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer person = repo.findOne(id);
         Customer updatedCustomer = new Customer.Builder().name("Cindy").build();
        
         repo.save(updatedCustomer);
         
         Customer newPerson = repo.findOne(id);
         Assert.assertEquals(newPerson.getFirstname(), "Cindy");
     }
     @Test(dependsOnMethods = "updateCustomer")
     private void deletePerson(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer cust = repo.findOne(id);
         repo.delete(cust);
         
         Customer deletedCustomer = repo.findOne(id);
         
         Assert.assertNull(deletedCustomer);
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