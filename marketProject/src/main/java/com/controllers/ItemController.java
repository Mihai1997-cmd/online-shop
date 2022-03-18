package com.controllers;


import com.models.Item;
import com.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //    @GetMapping(value ="/test", consumes = {MediaType.APPLICATION_JSON_VALUE })
//    @GetMapping("/items/{brandAuto}/{ID}")
//    public List<Item> getItem(@PathVariable("brandAuto") String brand, @PathVariable("ID") Long modelId) {
//        System.out.println(">>>>> brand="+brand+", modelId="+modelId);
//        return (List<Item>) itemRepository.findItem(1);
//    }
    //@GetMapping("/items/{IdModelAuto}")
    //public List<Item> getItem(@PathVariable("IdModelAuto") int IdModelAuto) {
        //System.out.println(">>>>> IdModelAuto="+IdModelAuto);
        //return (List<Item>) itemRepository.findItem(IdModelAuto);
    //}
    @GetMapping("/items")
    public List<Item> getItem() {
        System.out.println(">>>> calling getItems()");
        return (List<Item>) itemRepository.findAll();
    }

    @PostMapping("/items")
//    @PostMapping()
    void addItem(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @PutMapping("/items")
    void putItem(@RequestBody Item item) { itemRepository.save(item);}
}
