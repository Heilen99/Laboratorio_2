/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.lab2.entities.TipoArchivo;
import org.una.lab2.entities.Usuario;

/**
 *
 * @author Diana Acuña
 */
public interface ITipoArchivoService {

    public Optional<List<TipoArchivo>> findAll();

    public Optional<TipoArchivo> findById(Long id);

}
