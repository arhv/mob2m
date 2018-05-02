package com.mob2m.hairdressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;

@Repository
public interface CompanySubsidiariesRepository extends JpaRepository<CompanySubsidiaries, Long> {
	/*@Modifying(clearAutomatically = true)
	@Transactional
	@Query("SELECT new com.mob2m.hairdressing.model.dao.CompanySubsidiaries (c.id, c.companySubsidiaryName, c.companySubsidiaryType, c.companySubsidiaryCnpj,"
			+ "c.companySubsidiaryAddress, c.companySubsidiaryCep, c.companySubsidiaryState, c.companySubsidiaryCity)"
			+ " FROM tbl_company_subsidiaries c WHERE c.companyNameId=:id")
	List<CompanySubsidiaries> listSubsidiaries(@Param("id") Long id);*/
}
