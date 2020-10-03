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
import org.una.lab2.dto.TiposArchivoDTO;
import org.una.lab2.entities.TiposArchivo;
import org.una.lab2.services.ITiposArchivoService;
import org.una.lab2.utils.MapperUtils;

/**
 *
 * @author Diana Acuña
 */
@RestController
@RequestMapping("/tiposarchivos")
public class TiposArchivoController {

    @Autowired
    private ITiposArchivoService tiposArchivoService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TiposArchivo>> result =  tiposArchivoService.findAll();
            if (result.isPresent()) {
                List<TiposArchivoDTO> tiposArchivoDTO = MapperUtils.DtoListFromEntityList(result.get(), TiposArchivoDTO.class);
                return new ResponseEntity<>(tiposArchivoDTO, HttpStatus.OK);
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
            Optional<TiposArchivo> tipoArchivoFound = tiposArchivoService.findById(id);
            if (tipoArchivoFound.isPresent()) {
                TiposArchivoDTO tiposArchivoDTO = MapperUtils.DtoFromEntity(tipoArchivoFound.get(), TiposArchivoDTO.class);
                return new ResponseEntity<>(tiposArchivoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

