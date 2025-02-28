import Controllers.RentalController;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //Instancia de la clase
        RentalController rentalController = new RentalController();

        //Ingresando el dia de salida del vehiculo
        System.out.print("Ingrese la fecha de salida del vehiculo en formato YYYY-MM-DD: ");
        String exitDate = reader.nextLine();
        //CAMBIO
        rentalController.setExitDate(exitDate);

        System.out.print("Ingrese la fecha estimada a regresar el vehiculo en formato YYYY-MM-DD: ");
        String estimateDate = reader.nextLine();
        //CAMBIO
        rentalController.setEstimateReturnDate(estimateDate);

        //Funcion para calcular el tiempo total
        rentalController.calculateTotalDays();

        //Imprimir un mensaje el numero de veces que se presto el vehiculo
        if(rentalController.getTotalDays() > 0){
            for (int i = 1; i <= rentalController.getTotalDays(); i++) {
                System.out.println("Dia " + i + " de " + rentalController.getTotalDays() + " = " + (rentalController.getExitDay().plusDays(i)));
            }
        }

        //Ingresando el dia real de regreso del vehiculo
        System.out.print("Ingrese la fecha real en la que regreso el vehiculo en formato YYYY-MM-DD: ");
        String realDate = reader.nextLine();
        rentalController.setReturnDate(realDate);

        //Funcion para calcular los dias de retraso
        rentalController.calculateExtraDays();

        //Funcion para calcular el importe extra por los dias de retraso
        double pricePerDay = 1.50 * rentalController.getTotalDays();
        double billingTotal = rentalController.calculateBillingTotal(pricePerDay);
        System.out.println("El total por el alquiler del vehiculo es " + billingTotal);
    }
}