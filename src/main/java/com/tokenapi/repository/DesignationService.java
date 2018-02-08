/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokenapi.repository;


import com.tokenapi.en.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Abu Moridiyah
 */
public interface DesignationService extends JpaRepository<Employee,Integer> {
    
}
