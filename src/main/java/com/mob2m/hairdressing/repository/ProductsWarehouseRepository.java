package com.mob2m.hairdressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mob2m.hairdressing.model.dao.ProductsWarehouse;

@Repository
public interface ProductsWarehouseRepository extends JpaRepository<ProductsWarehouse, Long> {

}
