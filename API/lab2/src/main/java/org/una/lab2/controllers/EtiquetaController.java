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
import org.una.lab2.dto.EtiquetaDTO;
import org.una.lab2.dto.UsuarioDTO;
import org.una.lab2.entities.Etiqueta;
import org.una.lab2.entities.Usuario;
import org.una.lab2.services.IEtiquetaService;
import org.una.lab2.services.IUsuarioService;
import org.una.lab2.utils.MapperUtils;

/**
 *
 * @author Diana Acuña
 */
@RestController
@RequestMapping("/etiquetas")
public class EtiquetaController {

    @Autowired
    private IEtiquetaService etiquetaService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Etiqueta>> result = etiquetaService.findAll();
            if (result.isPresent()) {
                List<EtiquetaDTO> etiquetasDTO = MapperUtils.DtoListFromEntityList(result.get(), EtiquetaDTO.class);
                return new ResponseEntity<>(etiquetasDTO, HttpStatus.OK);
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
            Optional<Etiqueta> etiquetaFound = etiquetaService.findById(id);
            if (etiquetaFound.isPresent()) {
                EtiquetaDTO etiquetaDto = MapperUtils.DtoFromEntity(etiquetaFound.get(), EtiquetaDTO.class);
                return new ResponseEntity<>(etiquetaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
