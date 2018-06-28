/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.web.dao.impl;

import com.dixanta.web.dao.SettingDAO;
import com.dixanta.web.entity.Setting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class SettingDAOImpl implements SettingDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Setting> getAll() {
        String sql="select * from settings";
        return jdbcTemplate
                .query(sql, (ResultSet rs, int i) -> {
                    Setting setting=new Setting();
                    setting.setId(rs.getInt("id"));
                    setting.setName(rs.getString("name"));
                    setting.setValue(rs.getString("value"));
                    return setting;
        });
    }

    @Override
    public int insert(Setting model) {
        String sql="insert into settings(name,value)"
                + " values(?,?)";
        return jdbcTemplate
                .update(sql,new Object[]{model.getName(),
                model.getValue()});
    }

    @Override
    public int update(Setting model) {
        String sql="update settings set name=?,value=?"
                + " where id=?";
        return jdbcTemplate
                .update(sql,new Object[]{model.getName(),
                model.getValue(),model.getId()});
    }

    @Override
    public int delete(long id) {
        String sql="delete from settings  where id=?";
        return jdbcTemplate
                .update(sql,new Object[]{id});
    }

    @Override
    public Setting getById(long id) {
        String sql="select * from settings where id=?";
        return jdbcTemplate
                .queryForObject(sql,
                        new Object[]{id}, (ResultSet rs, int i) -> {
                    Setting setting=new Setting();
                    setting.setId(rs.getInt("id"));
                    setting.setName(rs.getString("name"));
                    setting.setValue(rs.getString("value"));
                    return setting;
        });
    }

    @Override
    public Setting getByName(String name) {
        String sql="select * from settings where name=?";
        return jdbcTemplate
                .queryForObject(sql,
                        new Object[]{name}, (ResultSet rs, int i) -> {
                    Setting setting=new Setting();
                    setting.setId(rs.getInt("id"));
                    setting.setName(rs.getString("name"));
                    setting.setValue(rs.getString("value"));
                    return setting;
        });
    }
    
}
