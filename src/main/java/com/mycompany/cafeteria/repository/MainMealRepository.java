/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.repository;

import com.mycompany.cafeteria.domain.MainMeal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sibakhulu
 */
public interface MainMealRepository extends JpaRepository<MainMeal, Long> {
    
}
