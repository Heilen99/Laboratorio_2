/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.lab2.entities.TiposArchivo;
import org.una.lab2.entities.Usuario;

/**
 *
 * @author Diana Acuña
 */
public interface ITiposArchivoService {

    public Optional<List<TiposArchivo>> findAll();

    public Optional<TiposArchivo> findById(Long id);

}
