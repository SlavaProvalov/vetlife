package com.source.model.dao;

import com.source.model.entity.Role;

public interface RoleDao extends GenericDAO<Role> {

    Role findRoleByName(String theRoleName);
}
