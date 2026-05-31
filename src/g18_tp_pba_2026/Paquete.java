/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

public class Paquete implements Comparable<Paquete>, Cloneable {

    private String id;
    private String descripcion;
    private double peso;
    private boolean urgente;

    public Paquete(String id, String descripcion, double peso, boolean urgente) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.urgente = urgente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso >= 0) {
            this.peso = peso;
        }
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    @Override
    public Paquete clone() {
        return new Paquete(this.id, this.descripcion, this.peso, this.urgente);
    }

    @Override
    public int compareTo(Paquete otro) {

        if (this.urgente && !otro.urgente) {
            return -1;
        }

        if (!this.urgente && otro.urgente) {
            return 1;
        }

        if (this.peso < otro.peso) {
            return -1;
        }

        if (this.peso > otro.peso) {
            return 1;
        }

        return this.id.compareTo(otro.id);
    }
    
    @Override
    public String toString() {
        return "Paquete: " + id
                + " | descripcion: " + descripcion
                + " | peso: " + peso
                + " | urgente: " + urgente;
    }
}