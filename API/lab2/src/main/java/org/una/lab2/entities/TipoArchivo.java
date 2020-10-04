/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Lab2_TiposArchivos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoArchivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo_Archivo", length = 45)
    private String tipoArchivo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoArchivo")
    private List<Foto> fotos = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;
    
}
