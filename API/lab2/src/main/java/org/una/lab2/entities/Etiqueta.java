/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Diana Acuña
 */
@Entity
@Table(name = "Lab2_Etiquetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etiqueta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", length = 45)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "Lab2_Fotos")
    private Foto foto;
    
    private static final long serialVersionUID = 1L;
    
}
