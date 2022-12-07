package com.natnael.antGym.service;

import com.natnael.antGym.dao.EquipmentDao;
import com.natnael.antGym.model.Equipment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// business logic
@Service
public class EquipmentService {
    // create a field for the dao (data access object)
    private final EquipmentDao dao;

    // EquipmentService es = new EquipmentService(new EquipmentDao() {});
    // @Autowired: dependency injection
    @Autowired
    public EquipmentService(EquipmentDao dao) {
        this.dao = dao;
    }

    // adds a record to the database table
    public Equipment addEquipment(Equipment item) {
        return this.dao.save(item);
    }

    // returns all records from the database table
    public List<Equipment> getAllEquipments() {
        return this.dao.findAll();
    }

    public Optional<Equipment> getEquipmentById(Long id) {
        return this.dao.findById(id);
    }

    public boolean deleteEquipmentById(Long id){
        boolean exist = dao.existsById(id);
        if (exist){
            dao.deleteById(id);
        }
        return exist;
    }

    // @Transactional makes the updates permanent
    @Transactional
    public Equipment updateEquipmentById(Long id, Equipment item){
        Optional<Equipment> optional=getEquipmentById(id);
        Equipment existing = null;
        // check if the value is present
        if (optional.isPresent()){
            // get the value
            existing = optional.get();
            // update the fields
            existing.setName(item.getName());
            existing.setDescription(item.getDescription());
            existing.setPrice(item.getPrice());
        }
        return existing;
    }
}
