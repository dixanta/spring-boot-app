/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.controller.api;

import com.dixanta.web.entity.Course;
import com.dixanta.web.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping(value = "/api/courses")
public class CourseAPIController {
    @Autowired
    private CourseRepository courseRepository;
    
    @GetMapping
    public ResponseEntity index(){
        return ResponseEntity.ok("hello");
    }
}
