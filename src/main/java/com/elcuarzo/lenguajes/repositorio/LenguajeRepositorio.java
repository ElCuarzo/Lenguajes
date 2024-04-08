package com.elcuarzo.lenguajes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elcuarzo.lenguajes.modelos.Lenguaje;

@Repository
public interface LenguajeRepositorio extends CrudRepository<Lenguaje, Long> {
		List<Lenguaje> findAll();
	}
