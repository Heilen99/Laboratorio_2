/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.lab2.entities.Calificacion;
import org.una.lab2.repositories.ICalificacionRepository;

/**
 *
 * @author Kender Porras
 */
@Service
public class CalificacionServiceImplementation implements ICalificacionService {

    @Autowired
    private ICalificacionRepository calificacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Calificacion>> findAll() {
        return Optional.ofNullable(calificacionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Calificacion> findById(Long id) {
        return calificacionRepository.findById(id);
    }
}
