/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public class PuntoDistribucion implements Conectable {

    private String nombre;
    private double coordenadaX;
    private double coordenadaY;
    private boolean conectado;
    private boolean visitado;

    public PuntoDistribucion(String nombre, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.conectado = false;
        this.visitado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public double distanciaA(PuntoDistribucion otro) {
        double dx = this.coordenadaX - otro.coordenadaX;
        double dy = this.coordenadaY - otro.coordenadaY;

        return Math.sqrt((dx * dx) + (dy * dy));
    }

    @Override
    public boolean conectarALaRed() {
        if (visitado) {
            conectado = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    @Override
    public String getNombreNodo() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Punto: " + nombre
                + " | x: " + coordenadaX
                + " | y: " + coordenadaY
                + " | conectado: " + conectado
                + " | visitado: " + visitado;
    }
}