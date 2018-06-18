package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasReceivablesDetails;

@Repository
public interface ComandasReceivablesDetailsRepository extends JpaRepository<ComandasReceivablesDetails, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT crd.id, crd.comandas_receivables_id, crd.effective_receivable_value, crd.effective_receivable_date "
			+ " FROM tbl_comandas_receivables_details crd WHERE crd.comandas_receivables_id=:id",
			nativeQuery = true)

	List<ComandasReceivablesDetails> listRemainingComandaPayment(@Param("id") Long id);

}
