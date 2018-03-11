/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

/**
 *
 *@author Estefani
 */
public class ListaGenerica {
    
    class Nodo {
        int x, y;
        Nodo ant,sig;
        
    }
    
    private Nodo raiz;
    
    public ListaGenerica () {
        raiz=null;
    }
      
    void insertar (int pos, int x, int y) {
        if (pos <= cantidad () + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.x = x;
            nuevo.y = y;
            if (pos == 1){
                nuevo.sig = raiz;
                if (raiz!=null)
                    raiz.ant=nuevo;
                raiz = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    Nodo reco = raiz;
                    while (reco.sig != null) {
                        reco = reco.sig;
                    }
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = null;
                } else {
                    Nodo reco = raiz;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.sig;
                    Nodo siguiente = reco.sig;
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
        }
    }

    public int extraer (int pos) {
        if (pos <= cantidad ())    {
            int informacion;
            if (pos == 1) {
                informacion = raiz.x;
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.x;
            }
            return informacion;
        }
        else
            return Integer.MAX_VALUE;
    }

//    public Nodo extraerNodo (int pos) {
//        int i = 1;
//        if (pos <= cantidad ())    {
//            Nodo n = new Nodo();
//            if (pos == 1) {
//                n = raiz;
//            
//                raiz = raiz.sig;
//                if (raiz!=null)
//                    raiz.ant=null;
//            } else {
//                Nodo reco;
//                reco = raiz;
//                for (int f = 1 ; f <= pos - 2 ; f++)
//                    reco = reco.sig;
//                Nodo prox = reco.sig;
//                reco.sig = prox.sig;
//                Nodo siguiente=prox.sig;
//                if (siguiente!=null)
//                    siguiente.ant=reco;
//                n = prox;
//            }
//            return n;
//        }
//        else
//            return new Nodo();
//    }
//      
    public void borrar (int pos)
    {
        if (pos <= cantidad ())    {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox!=null)
                    prox.ant=reco;
            }
        }
    }
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            Nodo reco1 = raiz;
            for (int f = 1 ; f < pos1 ; f++)
                reco1 = reco1.sig;
            Nodo reco2 = raiz;
            for (int f = 1 ; f < pos2 ; f++)
                reco2 = reco2.sig;
            int aux = reco1.x;
            reco1.x = reco2.x;
            reco2.x = aux;
        }
    }
    
    public int mayor () {
        int may =0;
        if (!vacia ()) {
            if (raiz.x == raiz.y)
                may = raiz.x + raiz.y;
            Nodo reco = raiz.sig;
            while (reco != null) {
                 if (reco.x == reco.y){
                     if (reco.x + reco.y > may)
                          may = reco.x + reco.y;
                 }
                reco = reco.sig;
            }
            return may;
        }
        else
            return Integer.MAX_VALUE;
    }
    
    public Nodo encontrar(int x, int y){
      Nodo reco=raiz;
        while (reco!=null) {
            if (reco.x == x && reco.y == y || reco.x == y && reco.y == x)
                return reco;
            reco=reco.sig;
        }
        return reco;
    }
    
    public Nodo extraerNodo(int pos){
      Nodo reco=raiz;
      int i = 1;
        while (reco!=null) {
            if (pos == i)
                return reco;
            reco=reco.sig;
            i++;
        }
        return reco;
    }
    
    public int cantidad (){
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public boolean ordenada() {
        if (cantidad()>1) {
            Nodo reco1=raiz;
            Nodo reco2=raiz.sig;
            while (reco2!=null) {
                if (reco2.x + reco2.y < reco1.x + reco1.y) {
                    return false;
                }
                reco2=reco2.sig;
                reco1=reco1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(int x, int y) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.x == x && reco.y == y || reco.x == y && reco.y == x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public int encontrarInt (int x, int y) {
        Nodo reco=raiz;
        int i =1;
        while (reco!=null) {
            if (reco.x == x && reco.y == y || reco.x == y && reco.y == x)
                return i;
            reco=reco.sig;
            i++;
        }
        return i;
    }
    
    public boolean vacia () {
        return raiz == null;
    }
    
    public void imprimir () {
        Nodo reco = raiz;
        double cont = 0;
        while (reco != null) {
           if (cont % 7 == 0)
               System.out.printf("\n");
           cont++;
            System.out.print (" "+reco.x + "-"+ reco.y);
            reco = reco.sig;
        }
        System.out.println();
    }
    
    public Nodo ultimo(){
        return extraerNodo(cantidad());
    }
    
    public Nodo primero(){
        return raiz;
    }
}
