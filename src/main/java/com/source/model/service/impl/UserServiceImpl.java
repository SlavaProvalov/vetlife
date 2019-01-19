package com.source.model.service.impl;

import com.source.model.dao.RoleDao;
import com.source.model.dao.UserDAO;
import com.source.model.entity.Role;
import com.source.model.entity.User;
import com.source.model.service.GenericService;
import com.source.model.service.UserService;
import com.source.model.user.CrmUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, GenericService<User> {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    @Deprecated
    public void saveOrUpdate(User item) {
        userDAO.saveOrUpdate(item);
    }

    @Override
    @Transactional
    public void delete(User item) {
        userDAO.delete(item);
    }

    @Override
    @Transactional
    public Optional<User> get(Class<User> item, int id) {
        return userDAO.get(item, id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid USERNAME of password"); // TODO probably need to localize it
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();

        user.setLogin(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));

        List<Role> userRoles = new ArrayList<>(crmUser.getRoles());
        for (Role userRole : userRoles) {
            user.addRole(roleDao.findRoleByName(userRole.getName()));
        }
        userDAO.saveOrUpdate(user);

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
