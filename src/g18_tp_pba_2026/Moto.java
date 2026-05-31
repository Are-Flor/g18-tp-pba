/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public class Moto extends Vehiculo {

    public Moto(String id, double bateriaMaxima, double capacidadCargaKg) {
        super(id, bateriaMaxima, capacidadCargaKg);
    }

    @Override
    public void desplazarse(double distanciaKm) {
        double consumo = distanciaKm * 0.5;
        consumirConRecargas(consumo);
    }
    
    @Override
    public String descripcionTipo() {
        return "Moto";
    }
    
    @Override
        public String toString() {
            return String.format("Moto: %s | bateria actual: %.2f%% | capacidad carga: %.2fkg | ultimo consumo: %.2f%% | recargas ultimo viaje: %d | minutos extra por carga: %d", 
                   id, bateriaActual, capacidadCargaKg, ultimoConsumo, recargasUltimoViaje, minutosExtraCarga);
}
    
    /*
    @Override
    public String toString() {
        return "Moto: " + id
                + " | bateria actual: " + bateriaActual + "%"
                + " | capacidad carga: " + capacidadCargaKg + "kg"
                + " | ultimo consumo: " + ultimoConsumo + "%"
                + " | recargas ultimo viaje: " + recargasUltimoViaje
                + " | minutos extra por carga: " + minutosExtraCarga;
    }
    */
}