/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.service;

import com.dixanta.web.entity.Setting;
import java.util.List;

/**
 *
 * @author USER
 */

public interface SettingService {
    List<Setting> getAll();
    Setting getById(long id);
    void save(Setting model);
    boolean delete(long id);
}
