package com.nana.userservice.service;

import com.nana.userservice.models.Role;
import com.nana.userservice.models.User;
import com.nana.userservice.repo.RoleRepo;
import com.nana.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplemetation implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database " , user.getName());
        return  userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role to the database " , role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info(" Adding role {}to user {} new role{} to the database database " , roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        log.info(" fetching user {} , username " );
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info(" Fetching all users");
        return userRepo.findAll();
    }
}
