package com.formacionbdi.microservicios.app.usuarios.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.service.AlumnoService;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {


	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, @PathVariable Long id, BindingResult result) {
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Alumno> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		Alumno alumnodb = o.get();
		alumnodb.setNombre(alumno.getNombre());
		alumnodb.setApellido(alumno.getApellido());
		alumnodb.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnodb));
	}
	
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}

}
