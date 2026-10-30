package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class SerializacionTest {

    @Test
    public void turismoIdaYVuelta() {
        Turismo original = new Turismo("1234ABC", Categoria.ESPECIAL, 2020, 5, 450.0);
        Vehiculo copia = FactoriaVehiculos.getVehiculo(original.toString());
        assertInstanceOf(Turismo.class, copia);
        assertEquals(original.toString(), copia.toString());
    }

    @Test
    public void motocicletaIdaYVuelta() {
        Motocicleta original = new Motocicleta("5678DEF", Categoria.SUPERIOR, 2019, 600);
        Vehiculo copia = FactoriaVehiculos.getVehiculo(original.toString());
        assertInstanceOf(Motocicleta.class, copia);
        assertEquals(600, ((Motocicleta) copia).getCilindrada());
        assertEquals(original.toString(), copia.toString());
    }

    @Test
    public void vehiculoIndustrialIdaYVuelta() {
        VehiculoIndustrial original = new VehiculoIndustrial("9999XYZ", Categoria.NORMAL, 2021, 3000, 3);
        original.setDisponible(true);
        Vehiculo copia = FactoriaVehiculos.getVehiculo(original.toString());
        assertInstanceOf(VehiculoIndustrial.class, copia);
        assertEquals(true, copia.isDisponible());
        assertEquals(original.toString(), copia.toString());
    }

    @Test
    public void tipoDesconocidoLanzaExcepcion() {
        String json = "{\"tipo\":\"Avion\",\"matricula\":\"X\",\"categoria\":\"NORMAL\",\"annio\":2020,\"disponible\":true}";
        assertThrows(IllegalArgumentException.class, () -> FactoriaVehiculos.getVehiculo(json));
    }

    @Test
    public void clienteIdaYVuelta() {
        Cliente original = new Cliente("Juan Pérez", "12345678A");
        Cliente copia = new Cliente(original.toString());
        assertEquals("Juan Pérez", copia.getNombre());
        assertEquals("12345678A", copia.getDni());
    }

    @Test
    public void alquilerIdaYVuelta() {
        Vehiculo moto = new Motocicleta("5678DEF", Categoria.NORMAL, 2019, 125);
        Cliente cliente = new Cliente("Ana López", "87654321B");
        Alquiler original = new Alquiler(moto, cliente, LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 4));
        Alquiler copia = new Alquiler(original.toString());
        assertInstanceOf(Motocicleta.class, copia.getVehiculo());
        assertEquals("Ana López", copia.getCliente().getNombre());
        assertEquals(LocalDate.of(2026, 11, 1), copia.getFechaInicio());
        assertEquals(LocalDate.of(2026, 11, 4), copia.getFechaFin());
        assertEquals(original.toString(), copia.toString());
    }
}