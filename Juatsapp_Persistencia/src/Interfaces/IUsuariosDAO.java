/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.Usuarios;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Abraham
 */
public interface IUsuariosDAO {
    boolean agregar(Usuarios usuario);
    List<Usuarios> consultarTodos();
    Usuarios loguear (String nombreUsuario, String contraseña);
    Usuarios consultarPorNombreUsuario (String nombreUsuario);
    Usuarios consultarPorCorreo(String correo);
    Usuarios actualizar(ObjectId id, String nombre, String nombreUsuario, String correo, String edad, String sexo);    
}
