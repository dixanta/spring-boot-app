/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.service.impl;

import com.dixanta.web.entity.Setting;
import com.dixanta.web.repository.SettingRepository;
import com.dixanta.web.service.SettingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service(value ="SettingServiceHImpl" )
public class SettingServiceHImpl implements SettingService{
    @Autowired
    private SettingRepository settingRepository;
    
    @Override
    public List<Setting> getAll() {
        return settingRepository.findAll();
    }

    @Override
    public Setting getById(long id) {
        return settingRepository
                .findById(id).get();
    }

    @Override
    public void save(Setting model) {
        settingRepository.save(model);
    }

    @Override
    public boolean delete(long id) {
        Setting setting=getById(id);
        if(setting!=null){
            settingRepository.delete(setting);
            return true;
        }
        return false;
    }
    
}
