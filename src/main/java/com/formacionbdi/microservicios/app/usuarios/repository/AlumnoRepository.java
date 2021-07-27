package com.formacionbdi.microservicios.app.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
