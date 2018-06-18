package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasReceivables;

@Repository
public interface ComandasReceivablesRepository extends JpaRepository<ComandasReceivables, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT cr.id, cr.company_subsidiary, cr.comanda_id, cr.payment_type, cr.number_parcels, cr.total_receivable_value, cr.receivable_date "
			+ " FROM tbl_comandas_receivables cr WHERE cr.comanda_id=:comandaId", nativeQuery = true)

	List<ComandasReceivables> listComandasPaymentsSaved(@Param("comandaId") Long comandaId);

}
