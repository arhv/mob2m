package com.mob2m.hairdressing.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Modifying
	@Query("UPDATE tbl_user c SET c.active =:active, c.insertdate =:insertdate, c.insertby=:insertby, c.email=:email, c.name=:name, c.phonenumber=:phonenumber,"
			+ "c.address=:address, c.zipCode=:zipCode, c.city=:city, c.state=:state WHERE c.id=:id")
	public int updateUser(@Param("id") Long id, @Param("active") boolean active, @Param("insertdate") Date insertdate,
			@Param("insertby") String insertby, @Param("email") String email, @Param("name") String name, @Param("phonenumber") String phonenumber,
			@Param("address") String address, @Param("zipCode") String zipCode, @Param("city") String city, @Param("state") String state);
}
