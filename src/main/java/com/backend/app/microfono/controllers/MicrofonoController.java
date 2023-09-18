package com.backend.app.microfono.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.microfono.models.entity.Microfono;
import com.backend.app.microfono.models.service.MicrofonoService;

@RestController
public class MicrofonoController {
	
	@Autowired
	private MicrofonoService microService;
	
	
	
	//Definicion de endpoints
	@GetMapping("/list")
	public List<Microfono> list(){
		return microService.findAll();
	}

	@GetMapping("/microfono/{id}")
	public Microfono detail(@PathVariable Long id) {
		return microService.findById(id);
	}
	
	 @PostMapping("/microfono")
	    public Microfono create(
	            @RequestParam String name,
	            @RequestParam String marca,
	            @RequestParam Date createdAt) {
	        Microfono microfono = new Microfono();
	        microfono.setName(name);
	        microfono.setMarca(marca);
	        microfono.setCreatedAt(createdAt);
	        return microService.save(microfono);
	    }

	    @DeleteMapping("/{id}")
	    public void drop(@PathVariable Long id) {
	        microService.delete(id);
	    }
}

//@DeleteMapping
//@PostMapping
//@Put...
