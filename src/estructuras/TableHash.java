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
public class TableHash {
    private int tamaño;
    private static int[] tamaños;
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float FactorUtil;
    private NodoHash[] vectorHash;
   
    public TableHash() {
        this.tamaños = new int[]{23,29,37,43,47,53,59,67,73,79,83,89,97,103,107,113,127,137,149,157,167,179,197,211,227,239,251,263,277,293,311,997, 1001, 2563};
        this.indiceTam=0;
        this.ocupados=0;
        this.FactorUtil=65.0f;
        this.tamaño=tamaños[indiceTam];
        this.vectorHash= new NodoHash[tamaño];
       
        this.porcentajeUtil=calcularPorcentajeUtil();
    }

    private float calcularPorcentajeUtil() {
        return (ocupados*100)/tamaño;
    }
    private int funcion1(int clave){
        return clave%tamaño;
    }
    private int Funcion2(int clave){
        return 1+(clave%(tamaño-1));
    }
    private int generarClave(String id){
        String codigo="";
        int tmp =0;
        for (int i = 0; i < id.length(); i++) {
            codigo+=id.codePointAt(i);
            
        }
        if(codigo.length()>15){
            return reduccion(codigo);
        }else{
            return Integer.parseInt(codigo);
        }
    }

    private int reduccion(String codigo) {
        int tmp=0;
        while(codigo.length()>15){
            String aux="";
            for (int i = 0; i < codigo.length(); i++) {
                aux+=codigo.charAt(i);
            }
            if(aux.length()>15){
                tmp=reduccion(aux);
                aux="";
            }else{
                tmp=Integer.parseInt(aux);
                aux="";
            }
            for (int i = codigo.length()/2; i < codigo.length(); i++) {
                aux+=codigo.charAt(i);
            }
            if(aux.length()>15){
                tmp=reduccion(aux);
                aux="";
            }else{
                tmp=Integer.parseInt(aux);
                aux="";
            }
            codigo=tmp+"";
            
        }
        return tmp;
    }
    private int DobleHashing(String id, int factor){
        int tmp=generarClave(id);
        return funcion1(tmp)+(factor*Funcion2(tmp)%tamaño);
    }
    public void insertar(String CodigoIngreso, String idt,String nombre, String apellido, String usuario, String correo, String contraseña ){
        boolean insertado=false;
        if(porcentajeUtil<=65.00f){
            for (int i = 0; i < tamaño; i++) {
                int posicion= DobleHashing(CodigoIngreso, i);
                if(posicion>tamaño){
                    posicion-=tamaño;
                }
                if(vectorHash[posicion]==null || vectorHash[posicion].estado=='b'){
                    vectorHash[posicion] = new NodoHash(CodigoIngreso,idt, nombre, apellido, usuario, correo, contraseña);
                    ocupados+=1;
                    porcentajeUtil=calcularPorcentajeUtil();
                    insertado=true;
                    break;
                }else{
                    if(vectorHash[posicion].id.equals(idt)){
                        System.out.println("La variable a insertar ya existe en latabla: "+usuario);
                        break;
                    }else{
                        System.out.println("Colision en la posicion: "+posicion);
                    }
                }
            }
            if(insertado==true){
                System.out.println("Se inserto correctamente el dato");
                
            }else{
                System.out.println("No se puedo insertar el dato");
            }
        }
        else{
            System.out.println("Hacer Rehashing -> Portacentaje util:"+porcentajeUtil);
            rehashing();
            insertar(CodigoIngreso,idt, nombre, apellido, usuario, correo, contraseña);
        }
    }
    
    
    
    
    private void rehashing() {
        NodoHash[] temp= vectorHash;
        int tamañotmp=tamaño;
        if(indiceTam<tamaños.length){
            indiceTam+=1;
            if(indiceTam==tamaños.length-1){
                System.out.println("Aviso: Se alcanzo el tamañomaximo del arreglo hasj");
            }
        }
        tamaño=tamaños[indiceTam];
        vectorHash=new NodoHash[tamaño];
        ocupados=0;
        porcentajeUtil=calcularPorcentajeUtil();
        for (int i = 0; i < tamañotmp; i++) {
            if(temp[i]!=null){
                insertar(temp[i].CodigoIngreso,temp[i].id, temp[i].nombre, temp[i].apellido,temp[i].Usuario , temp[i].correo,temp[i].contraseña);
            }
            
        }
        System.out.println("Rehashing realizado correctamente");
    }
    
    public NodoHash ExtraerNodo(String id){
        boolean encontrado=false;
        NodoHash tmp=null;
        int pos=0;
        for (int i = 0; i < tamaño; i++) {
            int posicion= DobleHashing(id,i);
            if(posicion>=tamaño){
                posicion-=tamaño;
                pos=posicion;
            }
            if(vectorHash[posicion]!=null){
                if(vectorHash[posicion].id.equals(id)){
                    tmp=vectorHash[posicion];
                    encontrado=true;
                    break;
                }
            }
        }
        if(encontrado){
            System.out.println("Se encontro la variable En la posicion: "+pos);
        }else{
            System.out.println("Lavariable "+id+"nose ecuentra en la tabla");
        }
        return tmp;
    }
}
