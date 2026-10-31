package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class FactoriaCalculadorPrecioTest {

    @Test
    public void creaCadaCalculadorDesdeElEnum() {
        assertInstanceOf(CalculadorPrecioNormal.class, FactoriaCalculadorPrecio.getCalculador(PoliticasDePrecios.Normal));
        assertInstanceOf(CalculadorPrecioTemporadaAlta.class, FactoriaCalculadorPrecio.getCalculador(PoliticasDePrecios.TemporadaAlta));
        assertInstanceOf(CalculadorPrecioOferton.class, FactoriaCalculadorPrecio.getCalculador(PoliticasDePrecios.Oferton));
        assertInstanceOf(CalculadorPrecioClienteFrecuente.class, FactoriaCalculadorPrecio.getCalculador(PoliticasDePrecios.ClienteFrecuente));
    }

    @Test
    public void creaCadaCalculadorDesdeSuNombre() {
        assertInstanceOf(CalculadorPrecioNormal.class, FactoriaCalculadorPrecio.getCalculador("Normal"));
        assertInstanceOf(CalculadorPrecioTemporadaAlta.class, FactoriaCalculadorPrecio.getCalculador("TemporadaAlta"));
        assertInstanceOf(CalculadorPrecioOferton.class, FactoriaCalculadorPrecio.getCalculador("Oferton"));
        assertInstanceOf(CalculadorPrecioClienteFrecuente.class, FactoriaCalculadorPrecio.getCalculador("ClienteFrecuente"));
    }

    @Test
    public void nombreDesconocidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> FactoriaCalculadorPrecio.getCalculador("Estudiante"));
    }

    @Test
    public void elCalculadorCreadoCalculaBien() {
        Vehiculo turismo = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        IcalculadorPrecio c = FactoriaCalculadorPrecio.getCalculador("TemporadaAlta");
        assertEquals(300, c.calcularPrecioAlquiler(LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 3), turismo));
    }
}