/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.util.Scanner;
import javaapplication9.ListaGenerica.Nodo;

/**
 *
 * @author Estefani
 */
public class Fichas {

    ListaGenerica pozo = new ListaGenerica();
    Jugador[] jugador = new Jugador[4];
    ListaGenerica juego = new ListaGenerica();
    int cantJug = 0;

    public Fichas(int cantJug) {
        this.cantJug = cantJug;
        llenar();
        repartirFichas();
        imprimir();

    }

    public Fichas() {
    }

    public void repartirFichas() {

        for (int i = 0; i < cantJug; i++) {
            jugador[i] = new Jugador(i + 1, this);
        }
    }

    public void imprimir() {
        System.out.printf("El Pozo \n");
        pozo.imprimir();
        for (int i = 0; i < cantJug; i++) {
            System.out.printf("\nEl Jugador " + (i + 1) + " \n");
            jugador[i].fichas.imprimir();

        }

        primerJugador();
    }

    public void primerJugador() {
        Nodo nodo;
        int n;
        n = 0;
        int mayor = jugador[0].fichas.mayor();
        for (int i = 1; i < cantJug; i++) {
            if (mayor < jugador[i].fichas.mayor()) {
                mayor = jugador[i].fichas.mayor();
                n = i;
            }
        }

        nodo = jugador[n].fichas.encontrar(mayor / 2, mayor / 2);

        jugar(n, nodo);
    }

    public void jugar(int jug, Nodo actual) {
        boolean terminar = false;
        int x, y;
        Scanner entrada;
        String cadena;
        System.out.print("Empieza el jugador numero " + (jug + 1) + " Con la ficha " + actual.x + "--" + actual.y + "\n");
        juego.insertar(1, actual.x, actual.y);
        jugador[jug].fichas.borrar(jugador[jug].fichas.encontrarInt(actual.x, actual.y));
        System.out.printf("\nEl Jugador " + (jug + 1) + " \n");
        jugador[jug].fichas.imprimir();
        do {
            if (jug + 1 == cantJug) {
                jug = 0;
            } else {
                jug++;
            }

            System.out.printf("\nJuego \n");
            juego.imprimir();
            System.out.printf("\nEl Jugador " + (jug + 1) + " \n");
            jugador[jug].fichas.imprimir();
            if (pozo.cantidad() != 0) {
                System.out.print("Comer del pozo? S/N");
                entrada = new Scanner(System.in);
                cadena = entrada.nextLine();
                if ("S".equals(cadena)) {
                    Nodo nod = comerPozo();
                    jugador[jug].fichas.insertar(jugador[jug].fichas.cantidad() + 1, nod.x, nod.y);
                    System.out.printf("\nPozo \n");
                    pozo.imprimir();
                    System.out.printf("\nEl Jugador " + (jug + 1) + " \n");
                    jugador[jug].fichas.imprimir();

                }
            }

         
            System.out.print("Elegir ficha: ");
            System.out.print("x: ");
            entrada = new Scanner(System.in);
            cadena = entrada.nextLine();
            x = Integer.parseInt(cadena);
            System.out.print("y: ");
            entrada = new Scanner(System.in);
            cadena = entrada.nextLine();
            y = Integer.parseInt(cadena);

            if (correcto(x, y)) {
                jugador[jug].fichas.borrar(jugador[jug].fichas.encontrarInt(x, y));
            } else {
                System.out.printf("NO PUEDE UTILIZAR ESA FICHA");
            }

            System.out.printf("\nEl Jugador " + (jug + 1) + " \n");
            jugador[jug].fichas.imprimir();
                

        } while (!terminar);

    }

    public Nodo comerPozo() {
        Nodo nodo = null;
        int cant = pozo.cantidad();
        int n = (int) (Math.random() * cant + 1);
        nodo = pozo.extraerNodo(n);
        pozo.borrar(n);
        return nodo;
    }

    public boolean correcto(int x, int y) {
        String mensaje;
        if (juego.primero().x == x && juego.ultimo().y == y || juego.primero().x == y && juego.ultimo().y == x) {
            System.out.print("¿Derecha o izquierda? D/I");
            Scanner entrada = new Scanner(System.in);
            mensaje = entrada.nextLine();

            if ("D".equals(mensaje)) {
                if (x == juego.primero().x) {
                    juego.insertar(1, y, x);
                } else {
                    juego.insertar(1, x, y);
                }
            } else if ("I".equals(mensaje)) {
                if (y == juego.ultimo().y) {
                    juego.insertar(juego.cantidad() + 1, y, x);
                } else {
                    juego.insertar(juego.cantidad() + 1, x, y);
                }
            }
        } else if (juego.primero().x == x || juego.primero().x == y) {
            if (x == juego.primero().x) {
                juego.insertar(1, y, x);
            } else {
                juego.insertar(1, x, y);
            }
        } else if (juego.ultimo().y == x || juego.ultimo().y == y) {
            if (y == juego.ultimo().y) {
                juego.insertar(juego.cantidad() + 1, y, x);
            } else {
                juego.insertar(juego.cantidad() + 1, x, y);
            }
        } else {
            return false;
        }

        return true;
    }

    public void llenar() {
        pozo.insertar(1, 0, 0);
        pozo.insertar(2, 1, 0);
        pozo.insertar(3, 1, 1);
        pozo.insertar(4, 2, 0);
        pozo.insertar(5, 2, 1);
        pozo.insertar(6, 2, 2);
        pozo.insertar(7, 3, 0);
        pozo.insertar(8, 3, 1);
        pozo.insertar(9, 3, 2);
        pozo.insertar(10, 3, 3);
        pozo.insertar(11, 4, 0);
        pozo.insertar(12, 4, 1);
        pozo.insertar(13, 4, 2);
        pozo.insertar(14, 4, 3);
        pozo.insertar(15, 4, 4);
        pozo.insertar(16, 5, 0);
        pozo.insertar(17, 5, 1);
        pozo.insertar(18, 5, 2);
        pozo.insertar(19, 5, 3);
        pozo.insertar(20, 5, 4);
        pozo.insertar(21, 5, 5);
        pozo.insertar(22, 6, 0);
        pozo.insertar(23, 6, 1);
        pozo.insertar(24, 6, 2);
        pozo.insertar(25, 6, 3);
        pozo.insertar(26, 6, 4);
        pozo.insertar(27, 6, 5);
        pozo.insertar(28, 6, 6);

    }

}
