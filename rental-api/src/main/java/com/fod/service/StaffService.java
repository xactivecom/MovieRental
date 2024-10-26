package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Staff;
import com.fod.repository.StaffRepository;

@Service
public class StaffService {
    
    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Optional<Staff> findById(Integer id) {
        return staffRepository.findById(id);
    }

    public List<Staff> findByStoreId(Integer store_id) {
        return staffRepository.findByStoreId(store_id);
    }

    public List<Staff> findByLastName(String last_name) {
        if (last_name.indexOf("*") > 0) {
            last_name = last_name.replaceAll("\\*", "%");
            return staffRepository.findByLastNameLike(last_name);
        } else {
            return staffRepository.findByLastName(last_name);
        }
    }
}
