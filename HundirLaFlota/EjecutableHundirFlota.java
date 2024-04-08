package Entregas.HundirLaFlota;

import Entregas.Datos.Ejercicio4.Persona;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EjecutableHundirFlota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Meter estos datos del array bideminsional con un archivo externo, y que el usuario pueda colocar sus barcos con un archivo
        //externo tambien
        int [][] posiciones = new int[10][10];

        String documento = "C:\\Users\\Eduardo\\Desktop\\Principal\\Programación\\HundirLaFlota\\TableroEnemigo.csv";
        try (Scanner scFile = new Scanner(new File(documento))){
            while (scFile.hasNextInt()){
                for (int fila = 0; fila < posiciones.length; fila++) {
                    for (int columna = 0; columna < posiciones[fila].length; columna++) {
                        posiciones[fila][columna] = scFile.nextInt();
                    }
                }
            }

        }catch (Exception e){
            System.out.println("Error de lectura");
        }


        ArrayList<Barco> barcos = new ArrayList<>();
        Tablero nuevo = new Tablero(posiciones, barcos);
        System.out.println("    __  __           _    _     _         ______ _           _           ");
        System.out.println("   |  \\/  |         | |  | |   (_)       |  ____(_)         | |          ");
        System.out.println("   | \\  / | __ _  __| |  | |    _  __ _  | |__   _ _ __   __| | ___ _ __ ");
        System.out.println("   | |\\/| |/ _` |/ _` |  | |   | |/ _` | |  __| | | '_ \\ / _` |/ _ \\ '__|");
        System.out.println("   | |  | | (_| | (_| |  | |___| | (_| | | |    | | | | | (_| |  __/ |   ");
        System.out.println("   |_|  |_|\\__,_|\\__,_|  |______|_|\\__, | |_|    |_|_| |_|\\__,_|\\___|_|   ");
        System.out.println("                                    __/ |                                ");
        System.out.println("                                   |___/                                 ");
        System.out.println("Bienvenido al juego de Hundir la Flota");
        System.out.println("--------------------------------------");
        menu(nuevo, sc);
    }

    public static void menu (Tablero nuevo, Scanner sc){
        int opcion;
        do {
            //Antes de esto hacer menu de contunuar partida o de nueva partida
            System.out.println("Pulsa 1 para ver el tablero rival");
            System.out.println("Pulsa 2 para disparar al tablero rival");
            //Hacer guardar partida para dejar todos los turnos y tableros en su situacion anterior
            System.out.println("Pulsa 3 para guardar partida");
            System.out.println("Pulsa 4 para salir de juego");

            opcion = Integer.parseInt(sc.nextLine());
            if (opcion !=4) {
                if (opcion == 1) {
                    tableroRival(nuevo);

                } else if (opcion == 2) {
                    disparar(nuevo, sc);
                } else if (opcion == 3) {
                    guardarPartida(nuevo);
                } else {
                    System.out.println("Introduce un número correcto...");
                }
            }
        }while (opcion != 4);
    }
    public static void tableroRival (Tablero nuevo){
        nuevo.mostrarTableroRival();
    }
    public static void disparar (Tablero nuevo, Scanner sc){
        int fila;
        int columna;
        System.out.println("----------Tablero rival-----------");
        nuevo.mostrarTableroRival();
        System.out.println("Selecciona una posicion del tablero a la que disparar (fila columna)");
        fila = sc.nextInt() -1;
        columna = sc.nextInt()-1;
        sc.nextLine();
        nuevo.disparar(fila, columna);
    }
    public static void guardarPartida (Tablero nuevo){

        System.out.println("Guardando partida espere unos instantes..........");

        File f = new File("C:\\Users\\Eduardo\\Desktop\\Principal\\Programación\\HundirLaFlota\\TableroEnemigo.csv");
        try (FileWriter fw = new FileWriter(f)){

            for (int fila = 0; fila < nuevo.getCasillas().length; fila++) {
                for (int columna = 0; columna < nuevo.getCasillas()[fila].length; columna++) {
                    fw.write(nuevo.getCasillas()[fila][columna] + " ");
                }
                fw.write("\n");
            }




        } catch (Exception e){
            System.out.println("Archivo existente, quieres sobreescribirlo o añadir datos al final?");
        }




        System.out.println("Partida guardada!");
    }
}
