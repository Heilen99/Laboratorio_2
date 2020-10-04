/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.lab2.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.lab2.entities.Usuario;

/**
 *
 * @author Heilen
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    /*@Query("SELECT u FROM Usuario u "
            + "JOIN u.fotos con ON con.usuarrio.id = u.id "
            + "WHERE UPPER(con.calificaciones.fechaRegistro) = UPPER(:fechaRegistro) and "
            + "UPPER(con.reacciones.fechaRegistro) = UPPER(:fechaRegistro)")
    public Optional<List<Usuario>> findByFechaRegistro(Long usuarioId);

    @Query(value = "SELECT u FROM Usuario u JOIN u.fotos f  JOIN f.reacciones "
            + "u where u.id=:usuarioId and u.fechaRegistro BETWEEN :startDate AND :endDate")
    public Optional<List<Usuario>>
            findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate);

    @Query(value = "SELECT u FROM Usuario u JOIN u.fotos f JOIN f.etiquetas e "
            + "e where e.nombre")
    public Optional<List<Usuario>> findByNombre(Long usuarioId);*/

}
