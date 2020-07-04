package Modelo;

import estructuras.Lista_Enlazada;


public class pregunta {
    private int tipo;
    private String pregunta;
    private Lista_Enlazada <String> opciones;
    
    public pregunta (int tipo, String pregunta, Lista_Enlazada <String> opciones){
        this.tipo = tipo;
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpciones(Lista_Enlazada<String> opciones) {
        this.opciones = opciones;
    }
    
    
    
}
