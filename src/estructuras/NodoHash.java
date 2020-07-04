/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Cristian
 */
public class NodoHash {
    char estado;
    String CodigoIngreso;
    String id;
    String nombre;
    String apellido;
    String Usuario;
    String correo;
    String contraseña;

    public NodoHash(String id, String nombre, String apellido, String Usuario, String correo, String contraseña,String CodigoIngreso) {
        this.CodigoIngreso=CodigoIngreso;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Usuario = Usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    
    
}
