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
                    YEPTDERLR();
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
         
             
        public static void YEPTDERLR(){
            char [][] refri = new char [8][7];
            int res=11;
            int puntos = 0;
            llenarrefri(refri);
            colocarcom(refri,'v',4);
            colocarcom(refri,'t',3);
            colocarcom(refri,'t',3);
            colocarcom(refri,'t',1);
            while(res>0){
            imprimichsr(refri);
                System.out.println("ingrese una fila (0-7)");
                int fil=sc.nextInt();
                while (fil>7){
                    System.out.println("ingrese una fila (0-7)");
                    fil=sc.nextInt();
                }
                System.out.println("ingrese una columna columna (0-6)");
                int col=sc.nextInt();
                 while (col>6){
                    System.out.println("ingrese una columna (0-6)");
                    fil=sc.nextInt();
                }
                int puntosgan=purgar(refri,fil,col);
                if (puntosgan>0){
                    puntos+=puntosgan;
                    res--;
                }
                System.out.println("comida restante: "+ res);
                System.out.println("puntos acumulados: "+puntos);
            }
        } 
        
        
        public static void llenarrefri(char [][] x){
            for (int i=0;i<x.length;i++){
                for (int j = 0;j<x[i].length;j++){
                    x[i][j]+='*';
                }
            }
        }
          public static void colocarcom(char[][]x ,char c ,int fre){
          int cont  =0;
          while (cont<fre){
              int fila = r.nextInt(8);
              int col = r.nextInt(7);
              if (x[fila][col]=='*'){
                  x[fila][col]=c;
                  cont++;
              }
          }
          
          
        }
          public static void imprimichsr(char [][] x) {
            for (int i = 0; i < x.length; i++) {          
                for (int j = 0; j < x[i].length; j++) {   
                    System.out.print("["+x[i][j] + "]");
                }
                System.out.println();
            }
        }
         public static int purgar(char [][]x,int fil, int col){
             if (x[fil][col]=='v'){
                 x[fil][col]=' ';
                 return 1;
             }
             if (x[fil][col]=='t'){
                 x[fil][col]=' ';
                 return 2;
             }
             if (x[fil][col]=='s'){
                 x[fil][col]=' ';
                 return 3;
                 
             }
             if (x[fil][col]=='p'){
                 x[fil][col]=' ';
                 return 5;
             }
            
                 System.out.println("ese espacion tiene comida buena, no la purges");
                 return 0;
         }
   
}
