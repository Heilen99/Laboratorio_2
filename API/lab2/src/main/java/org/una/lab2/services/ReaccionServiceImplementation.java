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
import org.una.lab2.entities.Reaccion;
import org.una.lab2.repositories.IReaccionRepository;

/**
 *
 * @author Diana Acuña
 */
@Service
public class ReaccionServiceImplementation implements IReaccionService {

    @Autowired
    private IReaccionRepository reaccionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Reaccion>> findAll() {
        return Optional.ofNullable(reaccionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reaccion> findById(Long id) {
        return reaccionRepository.findById(id);

    }
}
