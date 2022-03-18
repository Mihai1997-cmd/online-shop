package com.repositories;

import com.models.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Long> {}



//@Repository
//@EntityScan(basePackages = "com.models")
//public interface UserRepository extends JpaRepository<User, Long> {
//
//}
