/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.*;
import java.net.*; 
/**
 *
 * @author Estefani
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    try(Socket s = new Socket("localhost",6060)) {
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeUTF("Hello Server");
        dout.close();
   }catch(Exception e){System.out.println(e);}
    
    Fichas f = new Fichas(3);
    
    }
    
}

