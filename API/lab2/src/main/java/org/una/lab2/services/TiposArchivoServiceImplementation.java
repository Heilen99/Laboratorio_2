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
import org.una.lab2.entities.TiposArchivo;
import org.una.lab2.repositories.ITiposArchivoRepository;


/**
 *
 * @author Diana Acuña
 */
@Service
public class TiposArchivoServiceImplementation implements ITiposArchivoService{
     @Autowired
    private ITiposArchivoRepository tiposArchivoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TiposArchivo>> findAll() {
        return Optional.ofNullable(tiposArchivoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TiposArchivo> findById(Long id) {
        return tiposArchivoRepository.findById(id);
    }
}
