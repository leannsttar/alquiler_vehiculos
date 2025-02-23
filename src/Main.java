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
        rentalController.exitDate = LocalDate.parse(exitDate);

        System.out.print("Ingrese la fecha estimada a regresar el vehiculo en formato YYYY-MM-DD: ");
        String estimateDate = reader.nextLine();
        rentalController.estimateReturnDate = LocalDate.parse(estimateDate);

        //Funcion para calcular el tiempo total
        rentalController.calculateTotalDays();

        //Imprimir un mensaje el numero de veces que se presto el vehiculo
        if(rentalController.totalDays > 0){
            System.out.println("Dia 1 de " + rentalController.totalDays);
        }

        //Ingresando el dia real de regreso del vehiculo
        System.out.print("Ingrese la fecha real en la que regreso el vehiculo en formato YYYY-MM-DD: ");
        String realDate = reader.nextLine();
        rentalController.returnDate = LocalDate.parse(realDate);

        //Funcion para calcular los dias de retraso
        rentalController.calculateExtraDays();

        //Funcion para calcular el importe extra por los dias de retraso
        double pricePerDay = 1.50 * rentalController.totalDays;
        double billingTotal = rentalController.calculateBillingTotal(pricePerDay);
        System.out.println("El total por el alquiler del vehiculo es " + billingTotal);
    }
}