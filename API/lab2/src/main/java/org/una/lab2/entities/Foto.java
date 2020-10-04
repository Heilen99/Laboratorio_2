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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Kender Porras
 *
 *
 */
@Entity
@Table(name = "Lab2_Fotos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, unique = true)
    private String url;

    @Column(length = 50, name = "Nombre_Archivo")
    private String nombre_Archivo;

    @Column(name = "Tipo", length = 10)
    private String tipo;

    @Column(name = "Tamaño")
    private float tamaño;

    @Column(name = "Resolucion", length = 20)
    private String resolucion;

    @Column(name = "Tipo_Privacidad")
    private int tipo_Privacidad;

    @ManyToOne
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "Tipos_Archivos_Id")
    private TipoArchivo tipoArchivo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foto")
    private List<Calificacion> calificaciones = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foto")
    private List<Reaccion> reacciones = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foto")
    private List<Etiqueta> etiquetas = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
