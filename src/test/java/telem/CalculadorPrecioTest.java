package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculadorPrecioTest {

    private final Vehiculo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0); // 50 al día
    private final LocalDate inicio = LocalDate.of(2026, 11, 1);
    private final LocalDate fin3 = LocalDate.of(2026, 11, 3);   // 3 días
    private final LocalDate fin5 = LocalDate.of(2026, 11, 5);   // 5 días
    private final LocalDate fin10 = LocalDate.of(2026, 11, 10); // 10 días

    @Test
    public void normal() {
        assertEquals(150, new CalculadorPrecioNormal().calcularPrecioAlquiler(inicio, fin3, turismo));
    }

    @Test
    public void temporadaAltaDuplica() {
        assertEquals(300, new CalculadorPrecioTemporadaAlta().calcularPrecioAlquiler(inicio, fin3, turismo));
    }

    @Test
    public void ofertonCortoSoloTreintaPorCiento() {
        // 3 x 50 x 0,7 = 105
        assertEquals(105, new CalculadorPrecioOferton().calcularPrecioAlquiler(inicio, fin3, turismo));
    }

    @Test
    public void ofertonLargoDiezPorCientoExtra() {
        // 10 x 50 x 0,7 = 350, luego x 0,9 = 315
        assertEquals(315, new CalculadorPrecioOferton().calcularPrecioAlquiler(inicio, fin10, turismo));
    }

    @Test
    public void clienteFrecuenteTresDias() {
        // 3 x 40 = 120
        assertEquals(120, new CalculadorPrecioClienteFrecuente().calcularPrecioAlquiler(inicio, fin3, turismo));
    }

    @Test
    public void clienteFrecuenteCincoDias() {
        // 3 x 40 + 2 x 30 = 180
        assertEquals(180, new CalculadorPrecioClienteFrecuente().calcularPrecioAlquiler(inicio, fin5, turismo));
    }

    @Test
    public void alquilerEligeLaEstrategia() {
        Alquiler alquiler = new Alquiler(turismo, new Cliente("Ana", "1A"), inicio, fin3);
        assertEquals(150, alquiler.calcularPrecioAlquiler(inicio, fin3, PoliticasDePrecios.Normal, turismo));
        assertEquals(300, alquiler.calcularPrecioAlquiler(inicio, fin3, PoliticasDePrecios.TemporadaAlta, turismo));
        assertEquals(105, alquiler.calcularPrecioAlquiler(inicio, fin3, PoliticasDePrecios.Oferton, turismo));
        assertEquals(120, alquiler.calcularPrecioAlquiler(inicio, fin3, PoliticasDePrecios.ClienteFrecuente, turismo));
    }
}