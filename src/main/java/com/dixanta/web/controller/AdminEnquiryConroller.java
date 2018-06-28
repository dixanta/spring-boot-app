/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.controller;


import com.dixanta.web.dao.SettingDAO;
import com.dixanta.web.entity.Enquiry;
import com.dixanta.web.entity.ResponseData;
import com.dixanta.web.repository.CourseRepository;
import com.dixanta.web.repository.EnquiryRepository;
import com.dixanta.web.repository.SettingRepository;
import com.dixanta.web.service.SettingService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/admin/enquiries")
public class AdminEnquiryConroller {
    
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @GetMapping()
    public String index(){
        
        return "admin/enquiries/index";
    }
    
    @GetMapping(value = "/json")
    @ResponseBody
    public ResponseData<Enquiry> json(){
       ResponseData<Enquiry>
               datas=new ResponseData<>();
       datas.setData(enquiryRepository.findAll());
       return datas;
    }
    
    @GetMapping(value = "/search")
    @ResponseBody
    public ResponseData search(
            @RequestParam(value = "q",defaultValue = "",required = true)String q){
       ResponseData
               datas=new ResponseData();
       
       datas.setData(enquiryRepository.search(q));
       return datas;
    }
    
    @GetMapping(value = "/json/{id}")
    @ResponseBody
    public ResponseData json(@PathVariable("id")long id){
       ResponseData
               datas=new ResponseData();
       datas.setData(enquiryRepository.findById(id).get());
       return datas;
    }
    
    @PostMapping(value = "/save")
    @ResponseBody
    public ResponseData save(@ModelAttribute("Enquiry") Enquiry enquiry,
            HttpServletRequest request){
        enquiry.setIpaddress(request.getRemoteAddr());
        enquiryRepository.save(enquiry);
        ResponseData data=new ResponseData();
        data.setData(true);
        return data;
    }
    
    @PostMapping(value = "/delete")
    @ResponseBody
    public ResponseData delete(@RequestParam("id")long id){
        
        enquiryRepository.deleteById(id);
        ResponseData data=new ResponseData();
        data.setData(true);
        return data;
    }
}
