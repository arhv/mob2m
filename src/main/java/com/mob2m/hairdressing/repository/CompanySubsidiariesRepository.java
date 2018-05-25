package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;

@Repository
public interface CompanySubsidiariesRepository extends JpaRepository<CompanySubsidiaries, Long> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT cs.id, cs.company_subsidiary_name, cs.company_subsidiary_type, cs.company_subsidiary_cnpj, "
			+ "cs.company_subsidiary_address, cs.company_subsidiary_cep, cs.company_subsidiary_state, "
			+ "cs.company_subsidiary_city , cs.company_name_id, cd.nome, st.nome, cd.cod_cidades, st.cod_estados "
			+ "FROM tbl_company_subsidiaries cs JOIN tbl_cidades cd "
			+ "ON cs.company_subsidiary_city=cd.cod_cidades JOIN tbl_estados st " + "ON cs.company_subsidiary_state=st.cod_estados",
			nativeQuery = true)
	List<CompanySubsidiaries> listAllSubsidiaries();

}
