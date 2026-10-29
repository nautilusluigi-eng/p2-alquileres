package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AlquilerTest{

@Test 
public void turismoNormal(){
   
    Vehiculo a = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
    Cliente b = new Cliente("Juan Pérez", "12345678A");
    
    Alquiler t = new Alquiler(a, b, LocalDate.of(2026,10,28), LocalDate.of(2026,10,30));
    assertEquals(150, t.calcularPrecioAlquiler(LocalDate.of(2026,10,28), LocalDate.of(2026,10,30) ));
}
} 