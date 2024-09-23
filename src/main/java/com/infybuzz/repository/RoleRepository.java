package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
