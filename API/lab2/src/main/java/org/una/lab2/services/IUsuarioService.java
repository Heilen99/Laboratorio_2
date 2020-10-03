/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.lab2.entities.Usuario;

/**
 *
 * @author Heilen
 */
public interface IUsuarioService {
    
    public Optional<List<Usuario>> findAll();

    public Optional<Usuario> findById(Long id);
    
}
