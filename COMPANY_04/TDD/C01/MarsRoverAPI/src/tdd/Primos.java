/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.ArrayList;
import java.util.Scanner;


public class Primos {

    public static ArrayList<Integer> lista(int numero) {

        ArrayList<Integer> primos;
        primos = new ArrayList<Integer>();
        
        if (numero < 2) 
            return primos;

        boolean primo = false;
        for (int i = 2; i < numero; i++) {
            if(i > numero)
                return primos;
            
            primo = true;
            for (int x = 2; x <= i - 1; x++) {
                if (i % x == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo == true) 
                primos.add(i);
        };
      
        return primos;
    }

    public static void descomponer(ArrayList<Integer> primos, int numero) {
        if (numero < 2) {
            if (numero < 1) {
                return;
            } else {
                System.out.println('1');
                return;
            }
        }

        ArrayList<Integer> descomponer;
        descomponer = new ArrayList<Integer>();
        int temporal = numero;

        for (int numeroprimo : primos) {
            while (true) {
                if (temporal % numeroprimo == 0) {
                    descomponer.add(numeroprimo);
                    temporal = temporal / numeroprimo;
                    System.out.println(numeroprimo);
                } else {
                    break;
                }
            }
        }
    }

    public static int siguientePrimo(int valor)
    {   int i = 2; 
        while(true)
        {  if (valor % i != 0) 
                i++;
           else 
                return i;
        }
    }
    
    
    
    public static void main(String[] args) {
        int dev = 0;
        dev = Primos.siguientePrimo(10);
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el valor a descomponer:");
        int numero = in.nextInt();

        ArrayList<Integer> primos = new ArrayList<Integer>();
        primos = Primos.lista(numero);

        for (int i = 0; i < primos.size(); i++) {
            System.out.println(primos.get(i));
        }

        System.out.println("");
        System.out.println("Los numeros primos son");


        Primos.descomponer(primos, numero);

    }
}
