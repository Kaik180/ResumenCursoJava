package main.java.Proyectos.ExamExtraordinary;

import java.util.Scanner;

public class CulpaPadel {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Introduce el porcentaje de culpa de los 4 factores externos (pista, pala, compi, pelota): ");

            String culpas = teclado.nextLine();

            if (!culpas.matches("^\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}$")){
                System.out.println("Formato incorrecto.");
                continue;
            }

            String culpas_vector[] = culpas.split("-");

            int suma = 0;
            boolean control = false;

            for (int i = 0; i < culpas_vector.length; i++) {

                int num = Integer.parseInt(culpas_vector[i]);

                if (num<1 || num>90){
                    System.out.println("Valor incorrecto (debe estar entre 1 y 90)");
                    control = true;
                    break;
                }else{
                    suma += num;
                }

            }

            if (control){
                continue;
            }

            if (suma>=100){
                System.out.println("ERROR. La suma es mayor a 100.");
                continue;
            }

            System.out.println("Tienes un " + (100-suma) + "% de culpa.");

        }while(true);

    }
}
