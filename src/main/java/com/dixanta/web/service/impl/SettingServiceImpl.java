/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.service.impl;

import com.dixanta.web.dao.SettingDAO;
import com.dixanta.web.entity.Setting;
import com.dixanta.web.service.SettingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service(value = "SettingServiceImpl")
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingDAO settingDAO;
    
    @Override
    public List<Setting> getAll() {
        return settingDAO.getAll();
    }

    @Override
    public Setting getById(long id) {
        return settingDAO.getById(id);
    }

    @Override
    public void save(Setting model) {
        if(model.getId()==0){
            settingDAO.insert(model);
        }else{
           settingDAO.update(model);
        }
    }

    @Override
    public boolean delete(long id) {
        return settingDAO.delete(id)>0;
    }
    
}
