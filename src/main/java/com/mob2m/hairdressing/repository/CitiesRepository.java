package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.Cities;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("SELECT new com.mob2m.hairdressing.model.dao.Cities (c.id, c.estados_cod_estados, c.cod_cidades, c.nome, c.cep) FROM tbl_cidades c WHERE c.estados_cod_estados=:userState")
	List<Cities> getCitiesNames(@Param("userState") int userState);

}
