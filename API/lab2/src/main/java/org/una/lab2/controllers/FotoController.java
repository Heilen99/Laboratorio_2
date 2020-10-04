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
import org.una.lab2.dto.FotoDTO;
import org.una.lab2.entities.Foto;
import org.una.lab2.services.IFotoService;
import org.una.lab2.utils.MapperUtils;


/**
 *
 * @author Kender Porras
 */
@RestController
@RequestMapping("/fotos")
public class FotoController {
    
    @Autowired
    private IFotoService fotoService;
    
    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Foto>> result = fotoService.findAll();
            if (result.isPresent()) {
                List<FotoDTO> fotosDTO = MapperUtils.DtoListFromEntityList(result.get(), FotoDTO.class);
                return new ResponseEntity<>(fotosDTO, HttpStatus.OK);
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
            Optional<Foto> fotoFound = fotoService.findById(id);
            if (fotoFound.isPresent()) {
                FotoDTO fotoDto = MapperUtils.DtoFromEntity(fotoFound.get(), FotoDTO.class);
                return new ResponseEntity<>(fotoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
