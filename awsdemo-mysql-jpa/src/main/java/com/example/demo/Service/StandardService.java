package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.StandardRepository;
import com.example.demo.model.Standard;
 
@Service
@Transactional
public class StandardService {
 
    @Autowired
    private StandardRepository repo;
     
    public List<Standard> listAll() {
        return repo.findAll();
    }
     
    public Standard save(Standard Standard) {
        return repo.save(Standard);
    }
     
    public Standard get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
