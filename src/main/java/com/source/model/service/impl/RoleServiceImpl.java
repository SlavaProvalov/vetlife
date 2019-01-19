package com.source.model.service.impl;

import com.source.model.dao.RoleDao;
import com.source.model.entity.Role;
import com.source.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    @Transactional
    public void saveOrUpdate(Role item) {
        roleDao.saveOrUpdate(item);
    }

    @Override
    @Transactional
    public void delete(Role item) {
        roleDao.delete(item);
    }

    @Override
    @Transactional
    public Optional<Role> get(Class<Role> item, int id) {
        return roleDao.get(item, id);
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        return roleDao.getAll();
    }


    @Override
    @Transactional
    public Map<String, Role> getMapRoles() {
        Map<String, Role> roleStringMap = new HashMap<>();
        List<Role> roles = getAll();
        for (Role role : roles) {
            roleStringMap.put(role.getName(), role);
        }
        return roleStringMap;
    }
}
