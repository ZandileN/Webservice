/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.test.respository;

import com.mycompany.cafeteria.app.config.ConnectionConfig;
import com.mycompany.cafeteria.domain.Supplier;
import com.mycompany.cafeteria.repository.SupplierRepository;
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
public class SupplierRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private SupplierRepository repo;
    
    
    public SupplierRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createSupplier() {
     repo= ctx.getBean(SupplierRepository.class);
      Supplier supplier= new Supplier.Builder().id(id).name("ExxroSuppliers").build();
     
       repo.save(supplier);
         id = supplier.getId();
         Assert.assertNotNull(supplier);
     } 
    @Test (dependsOnMethods = "createPerson")
     public void readPerson(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "ExxroSuppliers");
     }
    
     @Test(dependsOnMethods = "readPerson")
     private void updateSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier sup = repo.findOne(id);
          Supplier updatedPerson = new Supplier.Builder()
                 .name("Boniface")
                 .build();
         //person.setFirstname("AngloSupp");
         repo.save(sup);
         
         Supplier updateSupplier = repo.findOne(id);
         Assert.assertEquals(updateSupplier.getName(), "AngloSupp");
    }
     @Test (dependsOnMethods = "updateSupplier")
     private void deleteSuppier(){
    
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         repo.delete(person);
         
         Supplier deletedPerson = repo.findOne(id);
         
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