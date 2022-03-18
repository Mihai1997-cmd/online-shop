package com.repositories;

import com.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ItemRepository extends CrudRepository<Item, Long> { }

//    @Query(value="SELECT Item.name, Item.description, Item.pret, Item.imageUrl FROM Item INNER JOIN ModelAuto ON ModelAuto.ID = Item.idModelAuto INNER JOIN BrandAuto ON BrandAuto.ID=ModelAuto.IdBrand where Item.idModelAuto=:IdModelAuto", nativeQuery = true)
    ////@Query(value="SELECT Item.* FROM Item INNER JOIN ModelAuto ON ModelAuto.ID = Item.idModelAuto " +
   //  cele 3 dublate functioneaza   //    "INNER JOIN BrandAuto ON BrandAuto.ID=ModelAuto.IdBrand where Item.idModelAuto=:IdModelAuto", nativeQuery = true)
   //// List<Item> findItem(@Param("IdModelAuto") Integer IdModelAuto);
//    @Query(value="Select Item.name from Item where IdModelAuto=:IdModelAuto", nativeQuery = true)
//    Item findItem(@Param("IdModelAuto") Integer IdModelAuto);
//    @Query(value="Select Item.name from Item", nativeQuery = true)
//    @Query(value="Select * from Item", nativeQuery = true)
//    List<Item> findItem();
//}

