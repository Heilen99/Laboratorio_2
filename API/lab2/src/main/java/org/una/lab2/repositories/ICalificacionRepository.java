/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.lab2.entities.Calificacion;

/**
 *
 * @author Kender Porras
 */
public interface ICalificacionRepository extends JpaRepository<Calificacion, Long>{
    
}
