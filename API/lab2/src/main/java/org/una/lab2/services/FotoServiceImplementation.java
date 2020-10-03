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
import org.una.lab2.entities.Foto;
import org.una.lab2.repositories.IFotoRepository;

/**
 *
 * @author Kender Porras
 */
@Service
public class FotoServiceImplementation implements IFotoService {

    @Autowired
    private IFotoRepository fotoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Foto>> findAll() {
        return Optional.ofNullable(fotoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Foto> findById(Long id) {
        return fotoRepository.findById(id);
    }
}
