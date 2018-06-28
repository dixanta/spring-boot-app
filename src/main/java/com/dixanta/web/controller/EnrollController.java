/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.controller;


import com.dixanta.web.dao.SettingDAO;
import com.dixanta.web.entity.Enquiry;
import com.dixanta.web.repository.CourseRepository;
import com.dixanta.web.repository.EnquiryRepository;
import com.dixanta.web.repository.SettingRepository;
import com.dixanta.web.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/enroll")
public class EnrollController {
    
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @GetMapping()
    public String index(Model model){
        model.addAttribute("courses",
                courseRepository.findAll());
        return "enroll/index";
    }
    
    @PostMapping()
    public String index(@ModelAttribute("Enquiry")
    Enquiry enquiry){
        enquiryRepository
                .save(enquiry);
        return "redirect:/";
    }
}
