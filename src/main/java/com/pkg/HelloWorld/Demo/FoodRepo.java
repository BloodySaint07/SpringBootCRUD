package com.pkg.HelloWorld.Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepo extends JpaRepository<FoodHub, Integer> {

}
