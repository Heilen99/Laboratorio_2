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
public class CalificacionDTO {
    
    private Long Id;
    private Date fechaRegistro;
    private Long fotoId;
    
}
