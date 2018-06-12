package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasDetailsProductsUsage;

@Repository
public interface ComandasDetailsProductsUsageRepository extends JpaRepository<ComandasDetailsProductsUsage, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT cdpu.comandas_master_id, cdpu.id, cdpu.comanda_details_type, cdpu.product_usage_id, cdpu.quantity_unitary_usage, cdpu.product_usage_cost, "
			+ "cdpu.professional_principal FROM tbl_comandas_details_products_usage cdpu WHERE cdpu.comandas_master_id=:id",
			nativeQuery = true)

	List<ComandasDetailsProductsUsage> listAllComandasDetailsProductsUsage(@Param("id") Long id);

	/*@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT SUM(cds.service_usage_value) as Total FROM tbl_comandas_details_services cds WHERE cds.comandas_master_id=:id GROUP BY(cds.comandas_master_id)",
	nativeQuery = true)
	int summAllComandasDetailsServices(@Param("id") Long id);*/

}
