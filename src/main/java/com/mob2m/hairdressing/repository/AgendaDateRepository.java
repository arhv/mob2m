package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.AgendaDate;

@Repository
public interface AgendaDateRepository extends JpaRepository<AgendaDate, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT ad.date_agenda, asb.company_subsidiary, am.priority_list, am.professional_principal, adt.customer_name, adt.service_id, adt.agenda_status, "
			+ "adtt.order_time, adtt.agenda_time, adtt.agenda_time_selected "
			+ "FROM tbl_agenda_date ad JOIN tbl_agenda_subsidiary asb ON ad.id=asb.agenda_date_id JOIN tbl_agenda_master am "
			+ "ON asb.id=am.agenda_subsidiary_id JOIN tbl_agenda_details adt ON am.id=adt.agenda_master_id "
			+ "JOIN tbl_agenda_details_time adtt ON adt.id=adtt.agenda_details_id", nativeQuery = true)
	List<AgendaDate> listAllAgenda();

}
