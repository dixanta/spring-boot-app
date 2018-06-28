/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.dao;

import com.dixanta.web.entity.Setting;
import java.util.List;

/**
 *
 * @author USER
 */
public interface SettingDAO {

    List<Setting> getAll();

    int insert(Setting model);

    int update(Setting model);

    int delete(long id);
    
    Setting getById(long id);
    Setting getByName(String name);
}
