package com.elcuarzo.lenguajes.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcuarzo.lenguajes.modelos.Lenguaje;
import com.elcuarzo.lenguajes.repositorio.LenguajeRepositorio;

@Service
public class LenguajesServicios {
	
	private final LenguajeRepositorio lenguajeRepositorio;
	
	// Se inicia la variable.
	public LenguajesServicios(LenguajeRepositorio lenguajeRepositorio) {
		this.lenguajeRepositorio = lenguajeRepositorio;
	}
	
	// Desplegar todos los lenguajes.
    public List<Lenguaje> TodosLosLenguajes() {
        return lenguajeRepositorio.findAll();
    }
    
    // Crear un lenguaje.
    public Lenguaje CrearLenguaje(Lenguaje b) {
        return lenguajeRepositorio.save(b);
    }
    
    // Encontrar un Lenguaje.
    public Lenguaje EncontrarLenguaje(Long id) {
        Optional<Lenguaje> lenguajeOpcional = lenguajeRepositorio.findById(id);
        if(lenguajeOpcional.isPresent()) {
            return lenguajeOpcional.get();
        } else {
            return null;
        }
    }

    // Actualizar un Lenguaje.
	public Lenguaje ActualizarLenguaje(Long id, String nombre, String creador, String version) {
		Optional<Lenguaje> lenguajeOpcional = lenguajeRepositorio.findById(id);
		if(lenguajeOpcional.isPresent()) {
			Lenguaje lenguaje = lenguajeOpcional.get();
			lenguaje.setNombre(nombre);
			lenguaje.setCreador(creador);
			lenguaje.setVersion(version);
			return lenguajeRepositorio.save(lenguaje);
		}
		else {
			return null;
		}
	}

	// Eliminar un Lenguaje.
	public void eliminarLenguaje(Long id) {
		lenguajeRepositorio.deleteById(id);
	}
}