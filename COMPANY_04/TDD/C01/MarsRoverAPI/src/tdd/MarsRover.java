/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

/**
 *
 * @author uda
 */
public class MarsRover {

    public int getFilaactual() {
        return filaactual;
    }

    public int getColumnaactual() {
        return columnaactual;
    }

    public void setFilaactual(int filaactual) {
        this.filaactual = filaactual;
    }

    public void setColumnaactual(int columnaactual) {
        this.columnaactual = columnaactual;
    }

    private char Orientacion;
    private int filaactual;
    private int columnaactual;
    
    public MarsRover()
    {
        Orientacion = 'N';
    }

    public void setOrientacion(char Orientation) {
        Orientacion = Orientation;
    }

    public char getOrientacion() {
        return Orientacion;
    }

    public int[] mover(int fila, int columna, char direccion, int maxfilas, int maxcolumnas) {
        int[][] matriz = new int[maxfilas][maxcolumnas];
        int nuevafila = fila;
        int nuevacolumna = columna;

        if (direccion == 'E') {
            if (nuevacolumna < maxcolumnas) {
                nuevacolumna++;
                nuevafila = fila;
            }
        }

        if (direccion == 'O') {

            if (nuevacolumna > 0) {
                nuevacolumna--;
                nuevafila = fila;
            }
        }

        if (direccion == 'N') {

            if (nuevafila < maxfilas) {
                nuevafila++;
                nuevacolumna = columna;
            }
        }

        if (direccion == 'S') {

            if (nuevafila > 0) {
                nuevafila--;
                nuevacolumna = columna;
            }
        }
        int[] nuevaposicion = {nuevafila, nuevacolumna};
        return nuevaposicion;
    }

    public char direccionarriba(char direccionactual) {
        return direccionactual;  //No cambia la direccion
    }

    public char direccionabajo(char direccionactual) {

        switch (direccionactual) {
            case 'N':
                return 'S';
            case 'S':
                return 'N';
            case 'E':
                return 'O';
            case 'O':
                return 'E';
            default:
                return 'X';


        }

    }

    public char direccionderecha(char direccionactual) {

        switch (direccionactual) {
            case 'N':
                return 'E';
            case 'S':
                return 'O';
            case 'E':
                return 'S';
            case 'O':
                return 'N';
            default:
                return 'X';
        }

    }

    public char direccionizquierda(char direccionactual) {

        switch (direccionactual) {
            case 'N':
                return 'O';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
            case 'O':
                return 'S';
            default:
                return 'X';
        }

    }

    public void movimiento() {
        char[] movimiento = {'f', 'f', 'b', 'r', 'l'};

        for (char actual : movimiento) {
            char ejemplo;
            int filaact = 0;
            int columnaact = 0;
            ejemplo = ' ';
            switch (actual) {
                case 'f': {
                    setOrientacion(direccionarriba(getOrientacion()));
                    System.out.println(getOrientacion());
                    this.mover(filaact, columnaact, getOrientacion(), 9, 9) ;
                    break;
                }

                case 'b': {
                    //setOrientacion(direccionabajo(getOrientacion()));
                    ejemplo = direccionabajo(getOrientacion());
                    //System.out.println("Al sur " + ejemplo);
                    setOrientacion(ejemplo);
                    System.out.println(getOrientacion());
                    break;
                }

                case 'r': {
                    setOrientacion(direccionderecha(getOrientacion()));
                    System.out.println(getOrientacion());
                    break;
                }


                case 'l': {
                    setOrientacion(direccionizquierda(getOrientacion()));
                    System.out.println(getOrientacion());
                    break;
                }


            }

        }



    }

    public static void main(String[] args) {
        MarsRover marciano = new MarsRover();
        marciano.movimiento();
    }
}