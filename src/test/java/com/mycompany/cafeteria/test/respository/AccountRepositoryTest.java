/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.Account;
import com.mycompany.cafeteria.repository.AccountRepository;
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
public class AccountRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private AccountRepository repo;
    public AccountRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createAccount() {
         repo = ctx.getBean(AccountRepository.class);
         Account account= new Account.Builder("").id(id)
                                                 .name("Zandile")
                                                 .balance(980.90).build();
                                             
         repo.save(account);
         id = account.getId();
         Assert.assertNotNull(account);
     }
     @Test(dependsOnMethods = "createAccount")
     public void readAccount(){
      repo = ctx.getBean(AccountRepository.class);
      
       Account account = repo.findOne(id);
       Assert.assertEquals(account.getName(), "Zandile");   
     }
     
     @Test(dependsOnMethods = "readAccount")
     private void updateAccount(){
         repo = ctx.getBean(AccountRepository.class);
         Account account = repo.findOne(id);
         Account updatedPerson = new Account.Builder("kabasob@cput.ac.za").id(id)
                                                                   .name("ZandileN")
                                                                   .balance(900.00).build();
         repo.save(updatedPerson);
         Account newPerson = repo.findOne(id);
         Assert.assertEquals(newPerson.getName(), "ZandileN");   
     }
     
     @Test(dependsOnMethods = "updateAccount")
     private void deletePerson(){
         repo = ctx.getBean(AccountRepository.class);
         Account account = repo.findOne(id);
         repo.delete(account);
         
         Account deletedPerson = repo.findOne(id);
         
         Assert.assertNull(deletedPerson); 
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