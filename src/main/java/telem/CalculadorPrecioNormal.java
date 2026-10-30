package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioNormal implements IcalculadorPrecio{

    @Override 
    public int calcularPrecioAlquiler(LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo){
        int dias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin) +1;
        return dias * vehiculo.getPrecioBase();
    }
}
