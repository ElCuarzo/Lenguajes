package com.elcuarzo.lenguajes.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elcuarzo.lenguajes.modelos.Lenguaje;
import com.elcuarzo.lenguajes.servicios.LenguajesServicios;

@Controller
public class LenguajeControlador {
	private final LenguajesServicios lenguajesServicio;

	public LenguajeControlador(LenguajesServicios lenguajeServicio) {
		this.lenguajesServicio = lenguajeServicio;
	}
	
	@RequestMapping("/lenguajes")
	public String lenguajes(Model model) {
		List<Lenguaje> lenguaje = lenguajesServicio.TodosLosLenguajes();
		model.addAttribute("lenguaje", lenguaje);
		return "/lenguajes.jsp";
	}
	
	@RequestMapping(value="/lenguajes", method=RequestMethod.POST)
	public String create(@RequestParam(value="nombre") String nombre, 
			   @RequestParam(value="creador") String creador,
			   @RequestParam(value="version") String version) {
		Lenguaje lenguaje = new Lenguaje(nombre, creador, version);
		lenguajesServicio.CrearLenguaje(lenguaje);
		return "redirect:/lenguajes";
	}
	
	@RequestMapping(value="/lenguajes/{id}", method= {RequestMethod.DELETE, RequestMethod.POST})
	public String eliminarLenguaje(@PathVariable("id") Long id) {
		lenguajesServicio.eliminarLenguaje(id);
		return "redirect:/lenguajes";
	}
	
	@RequestMapping(value="/lenguajes/editar/{id}", method=RequestMethod.POST)
	public String editarLenguajes(@PathVariable("id") Long id, Model model) {
		Lenguaje lenguaje = lenguajesServicio.EncontrarLenguaje(id);
		model.addAttribute("lenguaje", lenguaje);
		return "/editar.jsp";
	}
	
	
	@RequestMapping(value="/lenguajes/{id}", method=RequestMethod.PUT)
	public String actualizar(@PathVariable("id") Long id,
							   @RequestParam(value="nombre") String nombre,
							   @RequestParam(value="creador") String creador,
							   @RequestParam(value="version") String version) {
		Lenguaje lenguaje = lenguajesServicio.ActualizarLenguaje(id, nombre, creador, version);
		return "redirect:/lenguajes";
	}
	
	@RequestMapping("/lenguajes/mostrar/{id}")
	public String mostrarPorId(@PathVariable("id") Long id, Model model) {
		Lenguaje lenguaje = lenguajesServicio.EncontrarLenguaje(id);
		model.addAttribute("lenguaje", lenguaje);
		return "/mostrar.jsp";
	}
	
}
