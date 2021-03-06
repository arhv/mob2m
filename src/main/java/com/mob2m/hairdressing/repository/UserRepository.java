package com.mob2m.hairdressing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mob2m.hairdressing.model.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("SELECT new com.mob2m.hairdressing.model.dao.User (c.email) FROM tbl_user c WHERE c.email=:email")
	List<String> checkUserEmailExist(@Param("email") String email);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("SELECT new com.mob2m.hairdressing.model.dao.User (c.username) FROM tbl_user c WHERE c.username=:username")
	List<String> checkUsernameExist(@Param("username") String username);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE tbl_user c SET c.active =:active, c.insertdate =:insertdate, c.insertby=:insertby, c.email=:email, c.name=:name, c.phonenumber=:phonenumber,"
			+ "c.address=:address, c.zipCode=:zipCode, c.cityName=:city, c.stateName=:state WHERE c.id=:id")
	int updateUser(@Param("id") Long id, @Param("active") Boolean active, @Param("insertdate") Date insertdate, @Param("insertby") String insertby,
			@Param("email") String email, @Param("name") String name, @Param("phonenumber") String phonenumber, @Param("address") String address,
			@Param("zipCode") String zipCode, @Param("city") int cityName, @Param("state") int stateName);


}
