package com.controllers;


import com.models.Warehouse;
import com.repositories.WarehouseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {

    private final WarehouseRepository warehouseRepository;

    public WarehouseController(WarehouseRepository warehouseRepository){
        this.warehouseRepository=warehouseRepository;
    }


    @GetMapping("/warehouse")
    public List<Warehouse> getWarehouse() {
        System.out.println(">>>> calling getUsers()");
        return (List<Warehouse>) warehouseRepository.findAll();
    }

    @PostMapping("/warehouse")
    void addUser(@RequestBody Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }
}