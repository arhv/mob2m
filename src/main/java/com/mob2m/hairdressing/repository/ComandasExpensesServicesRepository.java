package com.mob2m.hairdressing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.ComandasExpensesServices;

@Repository
public interface ComandasExpensesServicesRepository extends JpaRepository<ComandasExpensesServices, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT es.id, es.company_subsidiary, es.expense_type, es.comanda_id, es.payment_date, es.professional_id, es.comanda_total_value, "
			+ "es.professional_service_percentage, es.professional_service_total_value, es.payment_type_id, es.payment_type_discount_percentage, "
			+ "es.payment_type_discount_value, es.total_professional_discounted, es.customer_id, es.service_id"
			+ " FROM tbl_expenses_services es WHERE es.professional_id=:professionalId and es.payment_date >=:startDate and es.payment_date <=:endDate",
			nativeQuery = true)

	List<ComandasExpensesServices> listComandasPaymentsPerProfessional(@Param("professionalId") Long professionalId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
