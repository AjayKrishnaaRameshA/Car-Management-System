package com.demo.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
