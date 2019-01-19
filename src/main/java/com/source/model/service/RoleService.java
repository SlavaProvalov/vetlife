package com.source.model.service;

import com.source.model.entity.Role;

import java.util.Map;

public interface RoleService extends GenericService<Role> {

    Map<String, Role> getMapRoles();

}
