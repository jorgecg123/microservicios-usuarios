package com.formacionbdi.microservicios.app.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

	@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno> findByNombreOrApellido(String term);
}
