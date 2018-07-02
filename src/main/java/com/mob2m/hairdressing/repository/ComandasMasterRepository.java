package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasMaster;

@Repository
public interface ComandasMasterRepository extends JpaRepository<ComandasMaster, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT cm.id, cm.date_comanda, cm.status, cm.comanda_type, cm.customer_name, cm.company_subsidiary "
			+ " FROM tbl_comandas_master cm WHERE cm.status=:status AND cm.company_subsidiary=:userSubisidiaryId", nativeQuery = true)

	List<ComandasMaster> listComandasOpened(@Param("status") String status, @Param("userSubisidiaryId") Long userSubisidiaryId);
}
