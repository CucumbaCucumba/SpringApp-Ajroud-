package com.ala.tp.service;

import com.ala.tp.entities.AppUser;

public interface IServiceSecurity {

    public AppUser loadUserByUserName(String username);

}
