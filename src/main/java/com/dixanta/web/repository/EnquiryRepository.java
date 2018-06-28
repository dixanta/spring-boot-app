/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.repository;

import com.dixanta.web.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author USER
 */
@Repository
public interface EnquiryRepository extends 
        JpaRepository<Enquiry, Long> {
    
    @Query(nativeQuery = true,value = "select * from enquiries "
            + "where first_name like %:q% or "
            + " last_name like %:q%" )
    List<Enquiry> search(@Param("q") String q);
}
