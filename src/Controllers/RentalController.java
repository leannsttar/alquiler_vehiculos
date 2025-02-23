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
        if(this.extraDays > 1){
            total += 1.00;
            System.out.println("Extra day 1 ");
        }
        if(this.extraDays > 3){
            total += 5.00;
            System.out.println("Extra day 2 ");
        }
        if(this.extraDays > 5){
            total += 10.00;
            System.out.println("Extra day 3 ");
        }
        if(this.extraDays > 7){
            total += 20.00;
            System.out.println("Extra day 4 ");
        }
        
        return total;
    }
}
