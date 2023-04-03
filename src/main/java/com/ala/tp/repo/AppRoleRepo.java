package com.ala.tp.repo;

import com.ala.tp.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole,Integer> {
    AppRole findAppUserByRolename(String rolename);
}