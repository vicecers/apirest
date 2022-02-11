package com.cersocode.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cersocode.app.entity.Estudiante;
import com.cersocode.app.repository.EstudianteRepository;
import com.cersocode.app.service.EstudianteService;

@RestController
public class EstudianteController {
	
	@Autowired
	EstudianteService estudianteService;
	

	@GetMapping("api/estudiante")
	public List<Estudiante> obtenerEstudiantes() {

		List<Estudiante> listaEstudiantes = new ArrayList<>();
		listaEstudiantes.add(new Estudiante(1, "cerso", "cerso", "cerso@gmail.com", 5d));
		listaEstudiantes.add(new Estudiante(1, "amadeo", "amadeo", "amadeo@gmail.com", 5d));
		listaEstudiantes.add(new Estudiante(1, "vicen", "vicen", "vicen@gmail.com", 5d));
		listaEstudiantes.add(new Estudiante(1, "dante", "dante", "dante@gmail.com", 5d));

		return listaEstudiantes;

	}
	
	@PostMapping("api/estudiantes")
	public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
		System.out.println(estudiante.toString());
		estudianteService.guardar(estudiante);
		return estudiante;
	}
	
	@GetMapping("api/estudiantes")
	public List<Estudiante> obtener(){
		return estudianteService.obtenerTodos();
	}
	
	@PutMapping("api/estudiantes/{id}")
	public Estudiante updateEstudiante(@PathVariable(value = "id")Integer i d, @RequestBody Estudiante estudianteDetalle) {
				
		return estudianteService.updateEstudiante(id, estudianteDetalle);
		
	}
	@DeleteMapping("/api/estudiantes/{id}")
	public void deleteEstudiante(@PathVariable(value = "id")Integer id) {
		estudianteService.deleteEstudiante(id);
	}
	
	@PostMapping("api/estudiantes/{id}")
	public Estudiante ObtenerEstudiante(@PathVariable(value = "id")Integer id) {
				
		return estudianteService.findOneEstudiante(id);
		
	}	

}
