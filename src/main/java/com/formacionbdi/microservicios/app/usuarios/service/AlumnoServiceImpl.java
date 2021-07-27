package com.formacionbdi.microservicios.app.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.repository.AlumnoRepository;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.service.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}
	

}

//@Service
//public class AlumnoServiceImpl implements AlumnoService {
//	
//	@Autowired
//	private AlumnoRepository repository;
//
//	@Override
//	@Transactional(readOnly = true)
//	public Iterable<Alumno> findAll() {
//
//		return repository.findAll();
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Optional<Alumno> findById(Long id) {
//
//		return repository.findById(id);
//	}
//
//	@Override
//	@Transactional
//	public Alumno save(Alumno alumno) {
//
//		return repository.save(alumno);
//	}
//
//	@Override
//	@Transactional
//	public void deleteById(Long id) {
//
//		repository.deleteById(id);;
//	}
//
//}
