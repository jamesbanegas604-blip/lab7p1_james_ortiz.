/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_james_ortiz;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author james
 */
public class Lab7p1_james_ortiz {
    static Scanner sc = new Scanner(System.in);
    static  Random r = new Random();
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        int op=menu();
        while(op!=3){
            switch (op){
                case 1:
                    break;
                case 2:
                    multimatrices();
                    break;
                    
                case 3:
                    System.out.println(" saliendo");
                    break;
                    
                default :
                    System.out.println("opcion invalida");
                    break;
            }
            op=menu();
        }
        
    }
    public static int menu(){
        int op;
        System.out.println("==MENU==");
        System.out.println("1. YEPTDELR; Y ese pancho Todo duro en la refri.");
        System.out.println("2. Multiplicacion de Matrices");
        System.out.println("3. salir");
        System.out.println("Elija una opcion");
        return op=sc.nextInt();
    }
    
    public static void YEPTDERLR(){
        
    }
    public static void multimatrices(){
        System.out.println(" MULTIPLICACION DE MATRICES");
        System.out.println("Filas de A: ");
        int fil1 = sc.nextInt();
        System.out.println("colmnas de A");
        int col1 = sc.nextInt();
        System.out.println("filas de B");
        int fil2 = sc.nextInt();
        System.out.println("columnas de b");
        int col2 = sc.nextInt();
        while(col1!=fil2||fil2!=col1){
            System.out.println("las columnas de a ("+col1+" deben ser iguales a las filas de B ("+fil2+")");
            System.out.println("columnas de A");
            col1 = sc.nextInt();
            System.out.println("filas de B");
            fil2 = sc.nextInt();
         
        } 
        
        int [][] mat1 = new int [fil1][col1];
        int [][] mat2 = new int [fil2][col2];
        mat1=lecturaramdom(fil1, col1);
        mat2=lecturaramdom(fil2, col2);
        imprimir(mat1,fil1,col1);
        imprimir2(mat2,fil2,col2);
        int [][]mat3 = new int [fil1][col2];
        for (int i=0;i<fil1;i++){
            for (int j=0;j<col2;j++){
                for  (int k=0;k<col1;k++){
                    mat3[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
            
        }
        imprimir3(mat3,fil1,col2);
       
    }
      public static int[][] lecturaramdom(int size, int size2) {
        int temp[][] = new int[size][size2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size2; j++) {
                temp[i][j] = 1 + r.nextInt(9); 
            }
        }
        return temp;
    }
        public static void imprimir(int[][] x,int a,int b) {
            System.out.println("Matriz A ("+a+"x"+b+")");
            for (int i = 0; i < x.length; i++) {          
                for (int j = 0; j < x[i].length; j++) {   
                     System.out.print("["+x[i][j] + "]");
                }
                System.out.println();
            }
        }
         public static void imprimir2(int[][] x,int a,int b) {
            System.out.println("Matriz b ("+a+"x"+b+")");
            for (int i = 0; i < x.length; i++) {          
                for (int j = 0; j < x[i].length; j++) {   
                    System.out.print("["+x[i][j] + "]");
                }
                System.out.println();
            }
        }
          public static void imprimir3(int[][] x,int a,int b) {
            System.out.println("Matriz A X B ("+a+"x"+b+")");
            for (int i = 0; i < x.length; i++) {          
                for (int j = 0; j < x[i].length; j++) {   
                    System.out.print("["+x[i][j] + "]");
                }
                System.out.println();
            }
        }
         
             
        public static char[][] agregarElementoRandom(char[][] tablero, char elemento) {
            int tamanoFilas = tablero.length;
            int tamanoColumnas = tablero[0].length;    
            int fila = r.nextInt(0, tamanoFilas);
            int columna = r.nextInt(0, tamanoColumnas);      
            while (tablero[fila][columna] != ' ') {
                fila = r.nextInt(1, tamanoFilas);
                columna = r.nextInt(1, tamanoColumnas);
            }
            tablero[fila][columna] = elemento;
            return tablero;
        }   
        
        public static char[][] llenartablero(char[][] tablero, int obstaculos) {
            for (int i = 0; i < tablero.length; i++) { 
                for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = ' ';
                }
            }
            tablero = agregarElementoRandom(tablero, 'T');
            tablero = agregarElementoRandom(tablero, 'P');
            
            int contador = 0;
            while (contador < obstaculos) {
                tablero = agregarElementoRandom(tablero, 'X');
                contador++;
            }
            return tablero;
         }
        public static void imprimirTablero(char[][] tablero) {
            for (int i = 0; i < tablero.length; i++) { 
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print("[" + tablero[i][j] + "]");
                }
                System.out.println("");
            }
        }
        
     
   
}
