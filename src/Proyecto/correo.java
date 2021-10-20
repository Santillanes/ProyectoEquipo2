/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author Santillanes
 */
public class correo {
    String usuarioCorreo, nombreArchivo, contra, rutaArchivo, destino, asunto, mensaje;
    
    public correo(){
        
    }

    public correo(String usuarioCorreo, String nombreArchivo, String contra, String rutaArchivo, String destino, String asunto, String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.nombreArchivo = nombreArchivo;
        this.contra = contra;
        this.rutaArchivo = rutaArchivo;
        this.destino = destino;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
