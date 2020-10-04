/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Diana Acuña
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TiposArchivoDTO {

    private Long id;
    private String tipoArchivo;

}
