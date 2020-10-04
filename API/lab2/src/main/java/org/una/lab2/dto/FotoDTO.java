/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Kender Porras
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class FotoDTO {
    
    private Long id;
    private String url;
    private String nombre_Archivo;
    private String tipo;
    private float tamaño;
    private String resolucion;
    private int tipo_Privacidad;
    private Long usuarioId;
    private Long tipoArchivoId;
    
}
