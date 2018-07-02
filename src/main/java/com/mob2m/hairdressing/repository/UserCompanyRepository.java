package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.UserCompany;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT uc.id, uc.username, uc.company_subsidiary, uc.user_role, uc.username_string, uc.user_role_string"
			+ " FROM tbl_user_company uc WHERE uc.username_string=:currentUserName", nativeQuery = true)

	List<UserCompany> listUserCompany(@Param("currentUserName") String currentUserName);

}
