package com.cersocode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cersocode.app.entity.Estudiante;
import com.cersocode.app.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	// CREATE
	public void guardar(Estudiante estudiante) {

		estudianteRepository.save(estudiante);

	}

	// READ ALL
	public List<Estudiante> obtenerTodos() {
		return estudianteRepository.findAll();
	}

	// DELETE
	public void deleteEstudiante(Integer id) {
		estudianteRepository.deleteById(id);
	}

	// UPDATE
	public Estudiante updateEstudiante(Integer id, Estudiante estudianteDetalle) {

		Estudiante estudiante = estudianteRepository.findById(id).get();

		estudiante.setNombre(estudianteDetalle.getNombre());
		estudiante.setApellido(estudianteDetalle.getApellido());
		estudiante.setEmail(estudianteDetalle.getEmail());
		estudiante.setNota(estudianteDetalle.getNota());

		return estudianteRepository.save(estudiante);
	}

	// FIND BY ID
	public Estudiante findOneEstudiante(Integer id) {

		Estudiante estudiante = estudianteRepository.findById(id).get();
		
		return estudiante;

	}

}
