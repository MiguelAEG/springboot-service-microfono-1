package com.backend.app.microfono.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.app.microfono.models.dao.MicrofonoDao;
import com.backend.app.microfono.models.entity.Microfono;


@Service
public class MicrofonoServiceImpl implements MicrofonoService {
	
	@Autowired
	private MicrofonoDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<Microfono> findAll() {
		return (List<Microfono>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Microfono findById(Long id) {
		return dao.findById(id).orElse(null);
	}
	
	 @Override
	    @Transactional
	    public Microfono save(Microfono microfono) {
	        return dao.save(microfono);
	    }

	 @Override
	 @Transactional
	 public void delete(Long id) {
	     dao.deleteById(id);
	 }
	 
	 @Override
	 @Transactional
	 public Microfono update(Long id, String name, String marca, Date createdAt) {
	     Microfono microfono = dao.findById(id).orElse(null);
	     if (microfono != null) {
	         microfono.setName(name);
	         microfono.setMarca(marca);
	         microfono.setCreatedAt(createdAt);
	         return dao.save(microfono);
	     }
	     return null; // Devolver null si el micrófono no existe
	 }

	@Override
	public Microfono update(Long id, String name, String marca, java.sql.Date createdAt) {
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

}