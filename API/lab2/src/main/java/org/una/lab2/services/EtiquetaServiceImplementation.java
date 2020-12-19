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
import org.una.lab2.entities.Etiqueta;
import org.una.lab2.repositories.IEtiquetaRepository;

/**
 *
 * @author Diana Acuña
 */
@Service
public class EtiquetaServiceImplementation  implements IEtiquetaService {
     @Autowired
    private IEtiquetaRepository etiquetaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Etiqueta>> findAll() {
        return Optional.ofNullable(etiquetaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Etiqueta> findById(Long id) {
        return etiquetaRepository.findById(id);
    }
    
}

