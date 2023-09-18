package com.backend.app.microfono.models.service;

import java.sql.Date;
import java.util.List;

import com.backend.app.microfono.models.entity.Microfono;

public interface MicrofonoService {
	
	public List<Microfono> findAll();
	
	public Microfono findById(Long id);

	public Microfono save(Microfono microfono);
	
	void delete(Long id);

	public Microfono update(Long id, String name, String marca, Date createdAt);

	Microfono update(Long id, String name, String marca, java.util.Date createdAt);

}
