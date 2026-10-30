package telem;

import java.time.LocalDate;

public interface IcalculadorPrecio {
    int calcularPrecioAlquiler(LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo);
    
}