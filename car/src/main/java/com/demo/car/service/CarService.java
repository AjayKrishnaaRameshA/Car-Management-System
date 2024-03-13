package com.demo.car.service;

import java.util.List;

import com.demo.car.model.Car;

public interface CarService {
	
	void save(Car car);
	
	List<Car> getAllCars();
	
	Car getCarById(Integer id);
	
	void deleteCar(Integer id);
	
}
