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

        bateriaActual = bateriaActual - consumo;

        if (bateriaActual < 0) {
            bateriaActual = 0;
        }
    }

    @Override
    public String descripcionTipo() {
        return "Moto";
    }

    @Override
    public String toString() {
        return "Moto: " + id
                + " | bateria actual: " + bateriaActual
                + " | capacidad carga: " + capacidadCargaKg;
    }
}