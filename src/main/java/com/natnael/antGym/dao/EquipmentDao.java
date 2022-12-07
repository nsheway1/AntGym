package com.natnael.antGym.dao;

import com.natnael.antGym.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// exposes the operations for the database table: add, update, delete, search (find)
// JpaRepository<T, ID>: T-Table, ID-datatype of ID
@Repository // tells Java that this encapsulates storage, retrieval, and search operation
public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
