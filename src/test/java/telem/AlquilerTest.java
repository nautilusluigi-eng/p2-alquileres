package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void precioMismoDia() {
        Alquiler alquiler = crearAlquiler();
        LocalDate dia = LocalDate.of(2026, 10, 28);
        assertEquals(50, alquiler.calcularPrecioAlquiler(dia, dia));
    }

    @Test
    public void precioUnaSemana() {
        Alquiler alquiler = crearAlquiler();
        assertEquals(350, alquiler.calcularPrecioAlquiler(LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 7)));
    }

    @Test
    public void precioCambioDeMes() {
        Alquiler alquiler = crearAlquiler();
        assertEquals(200, alquiler.calcularPrecioAlquiler(LocalDate.of(2026, 10, 30), LocalDate.of(2026, 11, 2)));
    }

    @Test
    public void precioAnnoBisiesto() {
        Alquiler alquiler = crearAlquiler();
        assertEquals(150, alquiler.calcularPrecioAlquiler(LocalDate.of(2028, 2, 28), LocalDate.of(2028, 3, 1)));
    }

    @Test
    public void gettersDevuelvenLoDelConstructor() {
        Vehiculo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan Pérez", "12345678A");
        LocalDate inicio = LocalDate.of(2026, 10, 28);
        LocalDate fin = LocalDate.of(2026, 10, 30);
        Alquiler alquiler = new Alquiler(turismo, cliente, inicio, fin);
        assertSame(turismo, alquiler.getVehiculo());
        assertSame(cliente, alquiler.getCliente());
        assertEquals(inicio, alquiler.getFechaInicio());
        assertEquals(fin, alquiler.getFechaFin());
    }

    @Test
    public void agregarAlquilerLoGuarda() {
        Alquiler alquiler = crearAlquiler();
        Alquiler.agregarAlquiler(alquiler);
        boolean encontrado = false;
        for (Alquiler a : Alquiler.obtenerAlquileres()) {
            if (a == alquiler) {
                encontrado = true;
            }
        }
        assertTrue(encontrado);
    }

    // Crea un alquiler cualquiera para los tests de precio
    private Alquiler crearAlquiler() {
        Vehiculo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        Cliente cliente = new Cliente("Juan Pérez", "12345678A");
        return new Alquiler(turismo, cliente, LocalDate.of(2026, 10, 28), LocalDate.of(2026, 10, 30));
    }
} 