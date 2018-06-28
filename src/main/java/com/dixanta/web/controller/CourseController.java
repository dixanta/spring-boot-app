/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.controller;


import com.dixanta.web.dao.SettingDAO;
import com.dixanta.web.entity.ResponseData;
import com.dixanta.web.repository.CourseRepository;
import com.dixanta.web.repository.SettingRepository;
import com.dixanta.web.service.SettingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {
    
    @Autowired
    private CourseRepository courseRepository;
    
    
    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id")long id, Model model){
        model.addAttribute("course",
                courseRepository.findById(id).get());
        return "course/detail";
    }
    
    @GetMapping(value = "/json")
    @ResponseBody
    public ResponseData json(){
        ResponseData data=new ResponseData();
        data.setData(courseRepository.findAll());
        return data;
    }
}
