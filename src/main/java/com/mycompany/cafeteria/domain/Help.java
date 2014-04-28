/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Sibakhulu
 */
@Embeddable
public class Help implements Serializable{
 private String question;
 
  private Help(Builder build){
         
         question=build.question;
        
}
   public static class Builder{
       private String question;
      
       
    
    public Builder name(String nam){
        question= nam;
        return this;
    }
     public Help build(){
       return new Help(this);
       } 
    public Builder copy(Help help){
        this.question=help.question;
        return this;
        
    }}

    public String getQuestion() {
        return question;
    }

   
 
 
}
