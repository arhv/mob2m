package com.mob2m.hairdressing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "SELECT ct.id, ct.customer_name, ct.phone_number, ct.email, ct.address, ct.zip_code, ct.city_name_id, ct.state_name_id, cd.nome, st.nome, cd.cod_cidades, st.cod_estados "
			+ "FROM tbl_customers ct JOIN tbl_cidades cd " + "ON cs.city_name_id=cd.cod_cidades JOIN tbl_estados st "
			+ "ON cs.state_name_id=st.cod_estados", nativeQuery = true)
	List<Customers> listAllCustomers();


}
