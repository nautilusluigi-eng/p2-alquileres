package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FicherosTest {

    @TempDir
    File carpeta; // carpeta temporal que JUnit borra al acabar

    @Test
    public void guardarYCargarRecuperaLosAlquileres() {
        String fichero = new File(carpeta, "alquileres.txt").getPath();

        GestorAlquileres original = new GestorAlquileres();
        Cliente clara = new Cliente("Clara Videncia", "001");
        Vehiculo moto = original.obtenerVehiculos("Motocicleta", Categoria.NORMAL)[0];
        Vehiculo camion = original.obtenerVehiculos("VehiculoIndustrial", Categoria.SUPERIOR)[0];
        original.agregarAlquiler(new Alquiler(moto, clara, LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 3)));
        original.agregarAlquiler(new Alquiler(camion, clara, LocalDate.of(2026, 11, 5), LocalDate.of(2026, 11, 9)));
        original.guardarAlquileres(fichero);

        GestorAlquileres copia = new GestorAlquileres();
        copia.cargarAlquileres(fichero);

        Alquiler[] recuperados = copia.obtenerAlquileres(clara);
        assertEquals(2, recuperados.length);
        assertInstanceOf(Motocicleta.class, recuperados[0].getVehiculo());
        assertInstanceOf(VehiculoIndustrial.class, recuperados[1].getVehiculo());
        assertEquals(LocalDate.of(2026, 11, 5), recuperados[1].getFechaInicio());
    }

    @Test
    public void guardarSinAlquileresDaFicheroVacio() {
        String fichero = new File(carpeta, "vacio.txt").getPath();
        new GestorAlquileres().guardarAlquileres(fichero);

        GestorAlquileres copia = new GestorAlquileres();
        copia.cargarAlquileres(fichero);
        assertEquals(0, copia.obtenerAlquileres(new Cliente("Clara Videncia", "001")).length);
    }

    @Test
    public void cargarFicheroInexistenteNoRompeLaApp() {
        GestorAlquileres gestor = new GestorAlquileres();
        gestor.cargarAlquileres(new File(carpeta, "no_existe.txt").getPath());
        assertEquals(0, gestor.obtenerAlquileres(new Cliente("Clara Videncia", "001")).length);
    }
}