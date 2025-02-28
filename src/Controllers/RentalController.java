package Controllers;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class RentalController {
    //Variables para llevar control de los dias en salio y entro el vehiculo
    private LocalDate exitDate;
    private LocalDate estimateReturnDate;
    private LocalDate returnDate;
    
    //Variable para llevar el tiempo total que se presto el vehiculo
    private int totalDays;
    private int extraDays;

    //AÑADIENDO SETTERS PARA ASIGNAR VALORES A LOS ATRIBUTOS PRIVADOS
    //setter de exitDate
    public void setExitDate (String date) {
        this.exitDate = LocalDate.parse(date);
    }

    //setter de estimateReturnDate
    public void setEstimateReturnDate (String date) {
        this.estimateReturnDate = LocalDate.parse(date);
    }

    //setter de returnDate
    public void setReturnDate (String date) {
        this.returnDate = LocalDate.parse(date);
    }

    //AÑADIENDO GETTERS PARA PODER OBTENER LOS ATRIBUTOS PRIVADOS
    //getter de totaldays
    public int getTotalDays() {
        return totalDays;
    }

    public LocalDate getExitDay() {
        return exitDate;
    }

    public void calculateTotalDays() {
        this.totalDays = Math.toIntExact(Duration.between(this.exitDate.atStartOfDay(), this.estimateReturnDate.atStartOfDay()).toDays());
    }

    public void calculateExtraDays() {
        this.extraDays = Math.toIntExact(Duration.between(this.estimateReturnDate.atStartOfDay(), this.returnDate.atStartOfDay()).toDays());
    }
    
    //Funcion para calcular el costo total del vehiculo
    public double calculateBillingTotal(double pricePerDay){
        double total = pricePerDay;

        
        //Calcular el costo extra por dias de retraso
//        if(this.extraDays > 1){
//            total += 1.00;
//            System.out.println("Extra day 1 ");
//        }
//        else if(this.extraDays > 3){
//            total += 5.00;
//            System.out.println("Extra day 2 ");
//        }
//        else if(this.extraDays > 5){
//            total += 10.00;
//            System.out.println("Extra day 3 ");
//        }
//        else if(this.extraDays > 7){
//            total += 20.00;
//            System.out.println("Extra day 4 ");
//        }

        if(this.extraDays > 7){
            total += 20.00;
            System.out.println("Extra day 4 ");
        }
        else if(this.extraDays > 5){
            total += 10.00;
            System.out.println("Extra day 3 ");
        }
        else if(this.extraDays > 3){
            total += 5.00;
            System.out.println("Extra day 2 ");
        }
        else if(this.extraDays > 1){
            total += 1.00;
            System.out.println("Extra day 1 ");
        }
        
        return total;
    }
}
