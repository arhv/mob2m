package com.mob2m.hairdressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.dao.Professionals;

@Repository
public interface ProfessionalsRepository extends JpaRepository<Professionals, Long> {
	/*@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT pf.id, pf.username_code, pf.company_subsidiary_id, csb.company_subsidiary_name, csb.id "
			+ "FROM tbl_professionals pf JOIN tbl_company_subsidiaries csb " + "ON pf.company_subsidiary_id=csb.id", nativeQuery = true)
	List<Professionals> listAllProfessionals();*/


}
