/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.lab2.dto.CalificacionDTO;
import org.una.lab2.entities.Calificacion;
import org.una.lab2.services.ICalificacionService;
import org.una.lab2.utils.MapperUtils;

/**
 *
 * @author Kender Porras
 */
@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private ICalificacionService calificacionService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Calificacion>> result = calificacionService.findAll();
            if (result.isPresent()) {
                List<CalificacionDTO> calificacionesDTO = MapperUtils.DtoListFromEntityList(result.get(), CalificacionDTO.class);
                return new ResponseEntity<>(calificacionesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Calificacion> calificacionesFound = calificacionService.findById(id);
            if (calificacionesFound.isPresent()) {
                CalificacionDTO calificacionesDTO = MapperUtils.DtoFromEntity(calificacionesFound.get(), CalificacionDTO.class);
                return new ResponseEntity<>(calificacionesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
