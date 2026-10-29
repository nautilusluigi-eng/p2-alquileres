package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VehiculoTest {

    @Test
    public void turismoNormal() {
        Vehiculo t = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        assertEquals("Turismo", t.getTipo());
        assertEquals(50, t.getPrecioBase());
    }

    @Test 
    public void motocicletaEspecial() {
        Vehiculo m = new Motocicleta("1234ABC", Categoria.ESPECIAL, 1997, 500);
        assertEquals("Motocicleta", m.getTipo());
        assertEquals(50, m.getPrecioBase());
    }

    @Test 
    public void vehiculoIndustrialSuperior() {
        Vehiculo v = new VehiculoIndustrial("1234ABC", Categoria.SUPERIOR, 2026, 2000, 5);
        assertEquals("VehiculoIndustrial", v.getTipo());
        assertEquals(150, v.getPrecioBase());
    }

        @Test
    public void turismoEspecial() {
        Vehiculo t = new Turismo("1234ABC", Categoria.ESPECIAL, 2020, 5, 400.0);
        assertEquals("Turismo", t.getTipo());
        assertEquals(80, t.getPrecioBase());
    }

    @Test
    public void turismoSuperior() {
        Vehiculo t = new Turismo("1234ABC", Categoria.SUPERIOR, 2020, 5, 400.0);
        assertEquals("Turismo", t.getTipo());
        assertEquals(100, t.getPrecioBase());
    }

    @Test
    public void motocicletaNormal() {
        Vehiculo m = new Motocicleta("1234ABC", Categoria.NORMAL, 1997, 500);
        assertEquals("Motocicleta", m.getTipo());
        assertEquals(30, m.getPrecioBase());
    }

    @Test
    public void motocicletaSuperior() {
        Vehiculo m = new Motocicleta("1234ABC", Categoria.SUPERIOR, 1997, 500);
        assertEquals("Motocicleta", m.getTipo());
        assertEquals(70, m.getPrecioBase());
    }

    @Test
    public void vehiculoIndustrialNormal() {
        Vehiculo v = new VehiculoIndustrial("1234ABC", Categoria.NORMAL, 2026, 2000, 5);
        assertEquals("VehiculoIndustrial", v.getTipo());
        assertEquals(80, v.getPrecioBase());
    }

    @Test
    public void vehiculoIndustrialEspecial() {
        Vehiculo v = new VehiculoIndustrial("1234ABC", Categoria.ESPECIAL, 2026, 2000, 5);
        assertEquals("VehiculoIndustrial", v.getTipo());
        assertEquals(120, v.getPrecioBase());
    }
}