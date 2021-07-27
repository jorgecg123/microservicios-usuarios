package com.formacionbdi.microservicios.app.usuarios.service;


import java.util.List;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.service.CommonService;

public interface AlumnoService extends CommonService<Alumno> {

	public List<Alumno> findByNombreOrApellido(String term);
}


//public interface AlumnoService {
//
//	public Iterable<Alumno> findAll();
//	
//	public Optional<Alumno> findById(Long id);
//	
//	public Alumno save(Alumno alumno);
//	
//	public void deleteById(Long id);
//}
