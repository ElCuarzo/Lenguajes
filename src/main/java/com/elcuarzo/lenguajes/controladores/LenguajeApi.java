package com.elcuarzo.lenguajes.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elcuarzo.lenguajes.modelos.Lenguaje;
import com.elcuarzo.lenguajes.servicios.LenguajesServicios;


@RestController
public class LenguajeApi {
	private final LenguajesServicios lenguajesServicios;

	public LenguajeApi(LenguajesServicios lenguajesServicios) {
		this.lenguajesServicios = lenguajesServicios;
	}
	
	//Generando metodo GET para mostrar todos los lenguajes
	@RequestMapping("/api/lenguajes")
	public List<Lenguaje> index(){
		return lenguajesServicios.TodosLosLenguajes();
	}
	
	//Generando un metodo POST para crear un lenguaje
	@RequestMapping(value="/api/lenguajes", method=RequestMethod.POST)
	public Lenguaje create(@RequestParam(value="nombre") String nombre, 
						   @RequestParam(value="creador") String creador,
						   @RequestParam(value="version") String version) {
		Lenguaje lenguaje = new Lenguaje(nombre, creador, version);
		return lenguajesServicios.CrearLenguaje(lenguaje);
	}
	
	//Generando metodo GET para mostrar lenguaje por id
	@RequestMapping("/api/lenguajes/{id}")
	public Lenguaje mostrar(@PathVariable("id") Long id) {
		Lenguaje lenguaje = lenguajesServicios.EncontrarLenguaje(id);
		return lenguaje;
	}
	
	//Generando metodo PUT para actualizar un lenguaje
	@RequestMapping(value="/api/lenguajes/{id}", method=RequestMethod.PUT)
	public Lenguaje actualizar(@PathVariable("id") Long id,
							   @RequestParam(value="nombre") String nombre,
							   @RequestParam(value="creador") String creador,
							   @RequestParam(value="version") String version) {
		Lenguaje lenguaje = lenguajesServicios.ActualizarLenguaje(id, nombre, creador, version);
		return lenguaje;
	}
	
	//Generando metodo DELETE para eliminar un lenguaje
	@RequestMapping(value="/api/lenguajes/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		lenguajesServicios.eliminarLenguaje(id);
	}
}
