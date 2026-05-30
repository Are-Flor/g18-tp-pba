/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public class Camion extends Vehiculo {

    private boolean tieneRemolque;

    public Camion(String id, double bateriaMaxima, double capacidadCargaKg, boolean tieneRemolque) {
        super(id, bateriaMaxima, capacidadCargaKg);
        this.tieneRemolque = tieneRemolque;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public void desplazarse(double distanciaKm) {
        double consumo;

        if (tieneRemolque) {
            consumo = distanciaKm * 2.5;
        } else {
            consumo = distanciaKm * 1.8;
        }

        bateriaActual = bateriaActual - consumo;

        if (bateriaActual < 0) {
            bateriaActual = 0;
        }
    }

    @Override
    public String descripcionTipo() {
        return "Camion";
    }

    @Override
    public String toString() {
        return "Camion: " + id
                + " | bateria actual: " + bateriaActual
                + " | capacidad carga: " + capacidadCargaKg
                + " | tiene remolque: " + tieneRemolque;
    }
}