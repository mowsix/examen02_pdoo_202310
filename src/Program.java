import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("================ D A G R A N =======================");

        //Aqui pedimos cuantos zonas se van a inicializar
        Scanner sc = new Scanner(System.in);
        int cantidadZonas = 0;
        boolean datoCorrecto = false;

        do {
            try {
                System.out.print("\nCuantas Zonas desea inicializar: ");
                cantidadZonas = sc.nextInt();
                if (cantidadZonas > 0) {
                    datoCorrecto = true;

                }
                else {
                    System.out.println("Error; Ingresa una cantidad valida de Zonas");
                }
            } catch (InputMismatchException errorDato) {
                System.out.println("Error; Ingrese correctamente el dato, por favor digital el numero de zonas nuevamente");
                sc.next();
            }
        }
        while (!datoCorrecto);

        System.out.println("Las Zonas Generadas Fueron:\n");
        Dagran misZonitas = new Dagran(cantidadZonas);
        for (Zona i:
             misZonitas.lasZonas) {
            System.out.println(i);
        }


        System.out.println(" \nLos porcentajes de zonas en riesgo segun su tipo fueron: \n");
        misZonitas.ObtienePorcentajeZonasPorTipo(misZonitas.lasZonas);
        for (String i:
                misZonitas.porcentajesTipoZona) {
            System.out.println(i);
        }

        System.out.println(" \nLos porcentajes de zonas en riesgo segun el tipo de inundacion fue: \n");
        misZonitas.ObtienePorcentajeRiesgosPorTipo(misZonitas.lasZonas);
        for (String i:
                misZonitas.porcentajesRiesgoInundacion) {
            System.out.println(i);
        }

    }





}