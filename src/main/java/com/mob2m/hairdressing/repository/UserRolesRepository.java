package com.mob2m.hairdressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.dao.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {


}
