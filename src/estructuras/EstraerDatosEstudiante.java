/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructuras;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EstraerDatosEstudiante {
    String CodigoIngreso;
    String id;
    String nombre;
    String apellido;
    String Usuario;
    String correo;
    String contraseña;
    TableHash tabladatos = new TableHash();

    public EstraerDatosEstudiante(String id, String nombre, String apellido, String Usuario, String correo, String contraseña) {
        this.CodigoIngreso = "1001";
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Usuario = Usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tabladatos.insertar(CodigoIngreso, id, nombre, apellido, Usuario, correo, contraseña);
    }

    
}
