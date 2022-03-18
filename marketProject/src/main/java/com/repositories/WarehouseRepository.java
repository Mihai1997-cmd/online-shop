package com.repositories;

import com.models.Warehouse;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {}


