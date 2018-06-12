package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasDetailsServices;

@Repository
public interface ComandasDetailsServicesRepository extends JpaRepository<ComandasDetailsServices, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT cds.comandas_master_id,cds.id,cds.comanda_details_type,cds.service_id,cds.service_usage_value,cds.professional_principal,"
			+ "cds.professional_aux_1,cds.professional_aux_2 FROM tbl_comandas_details_services cds WHERE cds.comandas_master_id=:id",
			nativeQuery = true)

	List<ComandasDetailsServices> listAllComandasDetailsServices(@Param("id") Long id);

	/*@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT SUM(cds.service_usage_value) as Total FROM tbl_comandas_details_services cds WHERE cds.comandas_master_id=:id GROUP BY(cds.comandas_master_id)",
	nativeQuery = true)
	int summAllComandasDetailsServices(@Param("id") Long id);*/

}
