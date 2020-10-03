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
import org.una.lab2.entities.TipoUsuario;
import org.una.lab2.repositories.ITipoUsuarioRepository;

/**
 *
 * @author Heilen
 */
@Service
public class TipoUsuarioServiceImplementation implements ITipoUsuarioService {
    
    @Autowired
    private ITipoUsuarioRepository tipoUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoUsuario>> findAll() {
        return Optional.ofNullable(tipoUsuarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUsuario> findById(Long id) {
        return tipoUsuarioRepository.findById(id);
    }
    
}
