package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class GestorAlquileresTest {

    @Test
    public void filtraPorTipoYCategoria() {
        GestorAlquileres gestor = new GestorAlquileres();
        Vehiculo[] r = gestor.obtenerVehiculos("Turismo", Categoria.NORMAL);
        assertEquals(1, r.length);
        assertEquals("TNA2020", r[0].getMatricula());
    }

    @Test
    public void filtraVehiculoIndustrialSuperior() {
        GestorAlquileres gestor = new GestorAlquileres();
        Vehiculo[] r = gestor.obtenerVehiculos("VehiculoIndustrial", Categoria.SUPERIOR);
        assertEquals(1, r.length);
        assertEquals("CSA2025", r[0].getMatricula());
    }

    @Test
    public void tipoInexistenteDevuelveArrayVacio() {
        GestorAlquileres gestor = new GestorAlquileres();
        assertEquals(0, gestor.obtenerVehiculos("Avion", Categoria.NORMAL).length);
    }

    @Test
    public void vehiculosDisponiblesAlEmpezar() {
        GestorAlquileres gestor = new GestorAlquileres();
        for (Vehiculo v : gestor.obtenerVehiculos("Motocicleta")) {
            assertTrue(v.isDisponible());
        }
    }

    @Test
    public void alquileresDeUnCliente() {
        GestorAlquileres gestor = new GestorAlquileres();
        Cliente clara = new Cliente("Clara Videncia", "001");
        Cliente aitor = new Cliente("Aitor Menta", "002");
        Vehiculo moto = gestor.obtenerVehiculos("Motocicleta", Categoria.NORMAL)[0];
        LocalDate hoy = LocalDate.of(2026, 11, 1);
        gestor.agregarAlquiler(new Alquiler(moto, clara, hoy, hoy.plusDays(2)));
        gestor.agregarAlquiler(new Alquiler(moto, aitor, hoy, hoy.plusDays(2)));
        gestor.agregarAlquiler(new Alquiler(moto, clara, hoy, hoy.plusDays(5)));

        assertEquals(2, gestor.obtenerAlquileres(clara).length);
        assertEquals(1, gestor.obtenerAlquileres(aitor).length);
    }

    @Test
    public void clienteSinAlquileres() {
        GestorAlquileres gestor = new GestorAlquileres();
        assertEquals(0, gestor.obtenerAlquileres(new Cliente("Lola Mento", "003")).length);
    }
}