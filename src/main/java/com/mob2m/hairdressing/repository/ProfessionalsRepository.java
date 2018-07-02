package com.mob2m.hairdressing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.dao.Professionals;

@Repository
public interface ProfessionalsRepository extends JpaRepository<Professionals, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT pf.id, pf.username_code, pf.company_subsidiary "
			+ " FROM tbl_professionals pf WHERE pf.company_subsidiary=:userSubisidiaryId ", nativeQuery = true)
	List<Professionals> listProfessionalsBySubsidiary(@Param("userSubisidiaryId") Long userSubisidiaryId);


}
