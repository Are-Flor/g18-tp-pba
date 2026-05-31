/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public class Repartidor {

    private String nombre;
    private double resistencia;
    private double pesoMaximoCarga;
    private PuntoDistribucion ubicacionActual;
    private Vehiculo vehiculo;

    public Repartidor(String nombre, double pesoMaximoCarga, PuntoDistribucion ubicacionActual) {
        this.nombre = nombre;
        this.resistencia = 100;
        this.pesoMaximoCarga = pesoMaximoCarga;
        this.ubicacionActual = ubicacionActual;
        this.vehiculo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public double getResistencia() {
        return resistencia;
    }

    public PuntoDistribucion getUbicacionActual() {
        return ubicacionActual;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void equiparVehiculo(Vehiculo v) {
        this.vehiculo = v;
    }

    public void desequiparVehiculo() {
        this.vehiculo = null;
    }

    public void descansar() {
        resistencia = resistencia + 30;

        if (resistencia > 100) {
            resistencia = 100;
        }
    }

    public boolean puedeCargar(Paquete p) {
        if (resistencia <= 20) {
            return false;
        }

        if (vehiculo == null) {
            return p.getPeso() <= pesoMaximoCarga;
        }

        return p.getPeso() <= vehiculo.getCapacidadCargaKg();
    }

    public boolean viajarA(PuntoDistribucion destino) {
        double distancia = ubicacionActual.distanciaA(destino);

        if (vehiculo != null) {
            vehiculo.desplazarse(distancia);

            System.out.println("Distancia recorrida: " + distancia + " km");
            System.out.println("Bateria consumida: " + vehiculo.getUltimoConsumo() + "%");
            System.out.println("Recargas necesarias: " + vehiculo.getRecargasUltimoViaje());
            System.out.println("Tiempo extra por recarga: " + vehiculo.getMinutosExtraCarga() + " minutos");

        } else {
            resistencia = resistencia - (distancia * 0.8);

            if (resistencia < 0) {
                resistencia = 0;
            }
        }

        ubicacionActual = destino;
        destino.setVisitado(true);

        return true;
    }

    @Override
    public String toString() {
        String textoVehiculo;

        if (vehiculo == null) {
            textoVehiculo = "Sin vehiculo";
        } else {
            textoVehiculo = vehiculo.toString();
        }

        return "Repartidor: " + nombre
                + " | resistencia: " + resistencia
                + " | peso maximo: " + pesoMaximoCarga
                + " | ubicacion actual: " + ubicacionActual.getNombre()
                + " | vehiculo: " + textoVehiculo;
    }
}