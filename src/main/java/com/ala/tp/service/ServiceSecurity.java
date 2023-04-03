package com.ala.tp.service;

import com.ala.tp.entities.AppUser;
import com.ala.tp.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSecurity implements IServiceSecurity {

    @Autowired
    AppUserRepo ur;

    @Override
    public AppUser loadUserByUserName(String username) {
        return ur.findAppUserByUsername(username);
    }
}
