package com.demo.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.car.model.Car;
import com.demo.car.service.CarService;

@Controller
public class CarController {

	@Autowired
	public CarService carService;
	

	@GetMapping("/")
	public String viewHomePage(Model model) {
		 model.addAttribute("carList",carService.getAllCars());
		 return "index";
	}
	
	@GetMapping("/add") //since we need to get new page we use GET MApping
	public String addEmployee(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("car") Car car) {
		carService.save(car);
		return "redirect:/";
	}
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable(value="id") Integer id, Model model) {
		Car car = carService.getCarById(id);
		model.addAttribute("car",car);
		return "updateCar";
	}
	
	@GetMapping("/delete/{id}") // using GET mapping as we are redirecting to index.html file
	public String deleteById(@PathVariable(value="id") Integer id) {
		carService.deleteCar(id);
		return "redirect:/";
	}
	

	

	
}
