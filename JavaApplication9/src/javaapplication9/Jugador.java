/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

/**
 *
 * @author Estefani
 */
public class Jugador {
    int numero;
    int posicion;
    ListaGenerica fichas = new ListaGenerica();
    Fichas pozo = new Fichas();
    
    public Jugador(){
    }
    
    public Jugador(int num, Fichas pozo){
        numero = num;
        this.pozo =  pozo;
        llenar();
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    public void setPozo (Fichas pozo ){
        this.pozo =pozo;
    }
    
     public Fichas getPozo(){
        return pozo;
    }
    
    public void llenar(){
        
        for (int i = 1; i <= 7; i++) {
            
            int x = (int) (Math.random() * 7);
            int y = (int) (Math.random() * 7);
            
            if (!pozo.pozo.vacia()){
                if (!fichas.existe(x, y) && pozo.pozo.existe(x, y)){
                    fichas.insertar(i, x, y);
                    pozo.pozo.borrar(pozo.pozo.encontrarInt(x, y));
                }
                else
                    i--;
            }
            else
                break;
        }
        
    }
}
