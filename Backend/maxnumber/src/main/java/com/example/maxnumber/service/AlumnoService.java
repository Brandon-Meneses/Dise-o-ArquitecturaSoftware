package com.example.maxnumber.service;

import com.example.maxnumber.model.Alumno;
import com.example.maxnumber.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(Long id, Alumno alumnoDetails) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setApellido(alumnoDetails.getApellido());
        alumno.setEdad(alumnoDetails.getEdad());
        alumno.setEmail(alumnoDetails.getEmail());
        alumno.setFechaInscripcion(alumnoDetails.getFechaInscripcion());
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}