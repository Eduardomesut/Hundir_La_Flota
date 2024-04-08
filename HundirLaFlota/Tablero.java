package Entregas.HundirLaFlota;

import java.util.ArrayList;

public class Tablero {

    private int[][] casillas;

    private ArrayList<Barco> barcos = new ArrayList<>();



    public Tablero(int[][] casillas, ArrayList<Barco> barcos) {
        this.casillas = casillas;
        this.barcos = barcos;
    }


    public void mostrarTableroRival() {
        System.out.println("Tablero Rival:");
        System.out.println("  A B C D E F G H I J");
        for (int fila = 0; fila < casillas.length; fila++) {
            System.out.print(fila + 1); // Número de fila, ajustando porque el índice comienza en 0
            if (fila < 9) System.out.print(" "); // Añade un espacio extra para alinear los dígitos de un solo carácter
            for (int columna = 0; columna < casillas[fila].length; columna++) {
                if (casillas[fila][columna] != 1 && casillas[fila][columna] != 2) {
                    System.out.print("~ "); // Casilla no disparada
                } else if(casillas[fila][columna] == 1) {
                    System.out.print("X "); // Disparo fallado
                } else if(casillas[fila][columna] == 2){
                    System.out.print("O "); // Disparo acertado
                }
            }
            System.out.println(); // Nueva línea al final de cada fila
        }
    }




    public void disparar(int fila, int columna){

        if (this.casillas[fila][columna] == 0){
            System.out.println("Agua!!!");
            this.casillas[fila][columna] = 1;
        } else if (this.casillas[fila][columna] == 10) {
            System.out.println("Disparo Acertado!!");
            this.casillas[fila][columna] = 2;

        }
    }

    public void meterBarco(Barco nuevo){

        this.barcos.add(nuevo);

    }

    public int[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(int[][] casillas) {
        this.casillas = casillas;
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }
}
