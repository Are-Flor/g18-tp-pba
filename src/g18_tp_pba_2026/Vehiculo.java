/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public abstract class Vehiculo {

    protected String id;
    protected double bateriaActual;
    protected double bateriaMaxima;
    protected double capacidadCargaKg;

    public Vehiculo(String id, double bateriaMaxima, double capacidadCargaKg) {
        this.id = id;
        this.bateriaMaxima = bateriaMaxima;
        this.bateriaActual = bateriaMaxima;
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public String getId() {
        return id;
    }

    public double getBateriaActual() {
        return bateriaActual;
    }

    public void setBateriaActual(double bateriaActual) {
        if (bateriaActual > bateriaMaxima) {
            this.bateriaActual = bateriaMaxima;
        } else if (bateriaActual < 0) {
            this.bateriaActual = 0;
        } else {
            this.bateriaActual = bateriaActual;
        }
    }

    public double getBateriaMaxima() {
        return bateriaMaxima;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void cargarBateria(double cantidad) {
        if (cantidad > 0) {
            bateriaActual = bateriaActual + cantidad;

            if (bateriaActual > bateriaMaxima) {
                bateriaActual = bateriaMaxima;
            }
        }
    }

    public double bateriaDisponible() {
        return (bateriaActual * 100) / bateriaMaxima;
    }

    public abstract void desplazarse(double distanciaKm);

    public abstract String descripcionTipo();

    @Override
    public String toString() {
        return "Vehiculo: " + id
                + " | bateria actual: " + bateriaActual
                + " | bateria maxima: " + bateriaMaxima
                + " | capacidad carga: " + capacidadCargaKg;
    }
}