package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioClienteFrecuente implements IcalculadorPrecio{

    @Override 
    public int calcularPrecioAlquiler(LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo){
        int dias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin) +1;
        int total = 0;
        
        for (int d =1; d<=dias; d++){
            if (d <= 3){
                total = total + vehiculo.getPrecioBase() * 80 / 100 ;
            }
            else {
                total = total + vehiculo.getPrecioBase() * 60 / 100;

            }



        }
        return total;

    }
}