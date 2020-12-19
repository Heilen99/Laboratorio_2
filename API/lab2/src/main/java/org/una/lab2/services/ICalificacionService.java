/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.services;

import java.util.List;
import java.util.Optional;
import org.una.lab2.entities.Calificacion;

/**
 *
 * @author Kender Porras
 */
public interface ICalificacionService {

    public Optional<List<Calificacion>> findAll();

    public Optional<Calificacion> findById(Long id);
}
