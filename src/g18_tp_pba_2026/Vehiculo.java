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

    protected double ultimoConsumo;
    protected int recargasUltimoViaje;
    protected int minutosExtraCarga;

    public Vehiculo(String id, double bateriaMaxima, double capacidadCargaKg) {
        this.id = id;

        if (bateriaMaxima > 0 && bateriaMaxima <= 100) {
            this.bateriaMaxima = bateriaMaxima;
        } else {
            this.bateriaMaxima = 100;
        }

        this.bateriaActual = this.bateriaMaxima;
        this.capacidadCargaKg = capacidadCargaKg;
        this.ultimoConsumo = 0;
        this.recargasUltimoViaje = 0;
        this.minutosExtraCarga = 0;
    }

    public String getId() {
        return id;
    }

    public double getBateriaActual() {
        return bateriaActual;
    }

    public double getBateriaMaxima() {
        return bateriaMaxima;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public double getUltimoConsumo() {
        return ultimoConsumo;
    }

    public int getRecargasUltimoViaje() {
        return recargasUltimoViaje;
    }

    public int getMinutosExtraCarga() {
        return minutosExtraCarga;
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

    protected void consumirConRecargas(double consumo) {
        ultimoConsumo = consumo;
        recargasUltimoViaje = 0;
        minutosExtraCarga = 0;

        if (consumo <= bateriaActual) {
            bateriaActual = bateriaActual - consumo;
        } else {
            double consumoRestante = consumo - bateriaActual;

            while (consumoRestante > 0) {
                recargasUltimoViaje++;
                consumoRestante = consumoRestante - bateriaMaxima;
            }

            minutosExtraCarga = recargasUltimoViaje * 15;

            bateriaActual = bateriaActual + (recargasUltimoViaje * bateriaMaxima) - consumo;

            if (bateriaActual < 0) {
                bateriaActual = 0;
            }

            if (bateriaActual > bateriaMaxima) {
                bateriaActual = bateriaMaxima;
            }
        }
    }
    
    public abstract void desplazarse(double distanciaKm);
    
    public abstract String descripcionTipo();
    
    @Override
        public String toString() {
            return String.format("Vehiculo: %s | bateria actual: %.2f%% | bateria maxima: %.2f%% | capacidad carga: %.2fkg | ultimo consumo: %.2f%% | recargas: %d | minutos extra: %d", 
                   id, bateriaActual, bateriaMaxima, capacidadCargaKg, ultimoConsumo, recargasUltimoViaje, minutosExtraCarga);
}
    
    
    /*
    @Override
    public String toString() {
        return "Vehiculo: " + id
                + " | bateria actual: " + bateriaActual + "%"
                + " | bateria maxima: " + bateriaMaxima + "%"
                + " | capacidad carga: " + capacidadCargaKg + "kg"
                + " | ultimo consumo: " + ultimoConsumo + "%"
                + " | recargas ultimo viaje: " + recargasUltimoViaje
                + " | minutos extra por carga: " + minutosExtraCarga;
    }
    */
}