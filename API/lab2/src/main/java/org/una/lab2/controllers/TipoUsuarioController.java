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
import org.una.lab2.dto.TipoUsuarioDTO;
import org.una.lab2.entities.TipoUsuario;
import org.una.lab2.services.ITipoUsuarioService;
import org.una.lab2.utils.MapperUtils;

/**
 *
 * @author Heilen
 */
@RestController
@RequestMapping("/tiposUsuarios")
public class TipoUsuarioController {
    
    @Autowired
    private ITipoUsuarioService tipoUsuarioService;
    
    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<TipoUsuario>> result = tipoUsuarioService.findAll();
            if (result.isPresent()) {
                List<TipoUsuarioDTO> tiposUsuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), TipoUsuarioDTO.class);
                return new ResponseEntity<>(tiposUsuariosDTO, HttpStatus.OK);
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
            Optional<TipoUsuario> tipoUsuarioFound = tipoUsuarioService.findById(id);
            if (tipoUsuarioFound.isPresent()) {
                TipoUsuarioDTO tipoUsuarioDto = MapperUtils.DtoFromEntity(tipoUsuarioFound.get(), TipoUsuarioDTO.class);
                return new ResponseEntity<>(tipoUsuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
