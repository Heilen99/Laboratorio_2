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
 * @author Heilen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class TipoUsuarioDTO {
    
    private Long id;
    private String tipoUsuario;
    private boolean estado;
    
}
