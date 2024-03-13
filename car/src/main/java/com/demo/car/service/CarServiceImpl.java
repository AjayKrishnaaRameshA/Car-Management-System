package com.demo.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.car.model.Car;
import com.demo.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepository;
	
	@Override
	public void save(Car car) {

		carRepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Integer id) {
		return carRepository.
				findById(id).
				orElseThrow(()->new RuntimeException("car not found"));
	}

	@Override
	public void deleteCar(Integer id) {
	
		Optional<Car> car=carRepository.findById(id);
		
		if(car.isPresent()) {
			carRepository.deleteById(id);
		}
	}

}
