/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeteria.repository;

import com.mycompany.cafeteria.domain.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sibakhulu
 */
public interface PurchaseItemRepository extends  JpaRepository<PurchaseItem, Long> {
    
}
