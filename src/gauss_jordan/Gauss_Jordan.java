//alan sanchez garrid

//segunda prueba de subir a git
package gauss_jordan;

import java.util.*;

public class Gauss_Jordan {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("este programa fue realizado para una materia de algebralineal");
        System.out.println("\n ESTE PROGRAMA SOLO DA RESULTADOS EN DECIMALES");
        
        System.out.print("Ingrese el numero de ecuaciones que utilizaras: ");
        int ecu = entrada.nextInt();
        
        
        System.out.print("Ingrese el numero de variables sin contar el resultado de la ecuacion: ");
        int vari = entrada.nextInt();

        double[][] matriz = new double[ecu][vari + 1];

       
        for (int i = 0; i < ecu; i++) {
            for (int j = 0; j < vari + 1; j++) {
                System.out.print("ingresa los numeros que estan alado de las variables  y el resultado de la ecuacion " + (i + 1) + ": ");
                matriz[i][j] = entrada.nextDouble();
            }
        }
        
        // aqui se aplica el metodo de gauss_jordan
        for (int i = 0; i < ecu; i++) {
            // Intercambiar filas si es necesario
            if (matriz[i][i] == 0) {
                boolean intercambioExitoso = false;
                for (int j = i + 1; j < ecu; j++) {
                    if (matriz[j][i] != 0) {
                    }
                }
                if (!intercambioExitoso) {
                    System.out.println("No se puede resolver el sistema de ecuaciones.");
                    return;
                }
            }
            
            // aqui hase que el coeficiente diagonal sea igual a 1
            double coeficienteDiagonal = matriz[i][i];
            for (int j = 0; j < vari + 1; j++) {
                matriz[i][j] /= coeficienteDiagonal;
                
               
            }

            // Hacer que los otros coeficientes de la columna sean igual a cero
            for (int k = 0; k < vari; k++) {
                if (k != i) {
                    double coeficienteActual = matriz[k][i];
                    for (int j = 0; j < vari + 1; j++) {
                        matriz[k][j] -= coeficienteActual * matriz[i][j];
                    }
                }
            }
            
        }
        // aqui se muestra el resultado le las varibales 
        System.out.println("\n Resultados de las variables");
        for (int i = 0; i < ecu; i++) {
            System.out.println("resultado de la variable " + (i + 1) + " = " + matriz[i][vari]);
        }
                // Calcular y mostrar la matriz inversa
        if (vari == ecu) {
            double[][] matrizInversa = new double[vari][vari];
            for (int i = 0; i < vari; i++) {
                for (int j = 0; j < vari; j++) {
                    matrizInversa[i][j] = matriz[i][j + vari];
                }
            }

            System.out.println("\nMatriz inversa:");
            for (int i = 0; i < vari; i++) {
                for (int j = 0; j < vari; j++) {
                    System.out.print(matrizInversa[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No se puede calcular la matriz inversa ya que el número de ecuaciones y variables es diferente.");
        }
    }

    }




