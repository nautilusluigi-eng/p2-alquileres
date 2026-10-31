package telem;

public class FactoriaCalculadorPrecio {

    public static IcalculadorPrecio getCalculador(PoliticasDePrecios politica) {
        switch (politica) {
            case TemporadaAlta:
                return new CalculadorPrecioTemporadaAlta();
            case Oferton:
                return new CalculadorPrecioOferton();
            case ClienteFrecuente:
                return new CalculadorPrecioClienteFrecuente();
            case Normal:
                return new CalculadorPrecioNormal();
            default:
                throw new IllegalArgumentException("Política desconocida: " + politica);
        }
    }

    public static IcalculadorPrecio getCalculador(String nombre){
        
        return getCalculador(PoliticasDePrecios.valueOf(nombre));

   }

   public static void main(String[] args) {
        Vehiculo v = new Turismo("1234ABC", Categoria.NORMAL, 2020, 5, 400.0);
        java.time.LocalDate ini = java.time.LocalDate.of(2026, 11, 1);
        java.time.LocalDate fin = java.time.LocalDate.of(2026, 11, 10);
        for (String nombre : new String[] {"Normal", "TemporadaAlta", "Oferton", "ClienteFrecuente"}) {
            IcalculadorPrecio c = FactoriaCalculadorPrecio.getCalculador(nombre);
            System.out.println(nombre + " -> " + c.getClass().getSimpleName() + ": " + c.calcularPrecioAlquiler(ini, fin, v));
        }
    }
}