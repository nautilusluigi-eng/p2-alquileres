package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioOferton implements IcalculadorPrecio{

    @Override 
    public int calcularPrecioAlquiler(LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo){
        int dias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin) +1;
        int total = dias * vehiculo.getPrecioBase() * 70 / 100 ;
        if (dias > 7){
            total = total*90/100;
        }
        return total;

    }
}