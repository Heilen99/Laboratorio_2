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
import org.una.lab2.dto.ReaccionDTO;
import org.una.lab2.entities.Reaccion;
import org.una.lab2.services.IReaccionService;
import org.una.lab2.utils.MapperUtils;

/**
 *
 * @author Diana Acuña
 */
@RestController
@RequestMapping("/reacciones")
public class ReaccionController {
     @Autowired
    private IReaccionService reaccionService;
    
    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Reaccion>> result = reaccionService.findAll();
            if (result.isPresent()) {
                List<ReaccionDTO> reaccionesDTO = MapperUtils.DtoListFromEntityList(result.get(), ReaccionDTO.class);
                return new ResponseEntity<>(reaccionesDTO, HttpStatus.OK);
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
            Optional<Reaccion> reaccionFound = reaccionService.findById(id);
            if (reaccionFound.isPresent()) {
                ReaccionDTO reaccionDto = MapperUtils.DtoFromEntity(reaccionFound.get(), ReaccionDTO.class);
                return new ResponseEntity<>(reaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
