/* TEST TEST TEST
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g18_tp_pba_2026;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Paquete> paquetes = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        ArrayList<PuntoDistribucion> puntos = new ArrayList<>();

        PuntoDistribucion base = new PuntoDistribucion("Central", 0, 0);

        Repartidor sam = new Repartidor("Sam", 15, base);

        int opcion;

        do {

            System.out.println("===============================");
            System.out.println(" BRIDGES DISTRIBUTION SYSTEM ");
            System.out.println("===============================");
            System.out.println("1. Gestion de paquetes");
            System.out.println("2. Gestion de vehiculos");
            System.out.println("3. Gestion de puntos");
            System.out.println("4. Repartidor");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    menuPaquetes(teclado, paquetes);
                    break;

                case 2:
                    menuVehiculos(teclado, vehiculos);
                    break;

                case 3:
                    menuPuntos(teclado, puntos);
                    break;

                case 4:
                    menuRepartidor(teclado, sam, vehiculos, puntos, paquetes);
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

    }

    public static void menuPaquetes(Scanner teclado, ArrayList<Paquete> paquetes) {

        int opcion;

        do {

            System.out.println("----- PAQUETES -----");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Clonar paquete");
            System.out.println("3. Listar paquetes");
            System.out.println("4. Ordenar paquetes");
            System.out.println("0. Volver");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    String id = teclado.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = teclado.nextLine();

                    System.out.print("Peso: ");
                    double peso = teclado.nextDouble();

                    System.out.print("Urgente (true/false): ");
                    boolean urgente = teclado.nextBoolean();

                    Paquete nuevo = new Paquete(id, descripcion, peso, urgente);

                    paquetes.add(nuevo);

                    System.out.println("Paquete agregado");

                    break;

                case 2:

                    if (paquetes.size() > 0) {

                        for (int i = 0; i < paquetes.size(); i++) {
                            System.out.println(i + " - " + paquetes.get(i));
                        }

                        System.out.print("Seleccione posicion: ");
                        int pos = teclado.nextInt();
                        teclado.nextLine();

                        if (pos >= 0 && pos < paquetes.size()) {

                            Paquete clon = paquetes.get(pos).clone();

                            System.out.print("Nuevo ID: ");
                            String nuevoId = teclado.nextLine();

                            clon.setId(nuevoId);

                            paquetes.add(clon);

                            System.out.println("Paquete clonado");

                        } else {

                            System.out.println("La posicion ingresada no existe");
                        }
                    } else {
                        System.out.println("No hay paquetes");
                    }

                    break;

                case 3:

                    if (paquetes.size() == 0) {
                        System.out.println("No hay paquetes");
                    } else {

                        for (int i = 0; i < paquetes.size(); i++) {
                            System.out.println(paquetes.get(i));
                        }
                    }

                    break;

                case 4:

                    Collections.sort(paquetes);

                    System.out.println("Paquetes ordenados por urgencia, peso e ID");

                    break;
            }

        } while (opcion != 0);

    }

    public static void menuVehiculos(Scanner teclado, ArrayList<Vehiculo> vehiculos) {

        int opcion;

        do {

            System.out.println("----- VEHICULOS -----");
            System.out.println("1. Registrar moto");
            System.out.println("2. Registrar camion");
            System.out.println("3. Listar vehiculos");
            System.out.println("0. Volver");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    String idMoto = teclado.next();

                    System.out.print("Bateria maxima: ");
                    double batMoto = teclado.nextDouble();

                    System.out.print("Capacidad carga: ");
                    double capMoto = teclado.nextDouble();

                    Moto moto = new Moto(idMoto, batMoto, capMoto);

                    vehiculos.add(moto);

                    System.out.println("Moto agregada");

                    break;

                case 2:

                    System.out.print("ID: ");
                    String idCamion = teclado.next();

                    System.out.print("Bateria maxima: ");
                    double batCamion = teclado.nextDouble();

                    System.out.print("Capacidad carga: ");
                    double capCamion = teclado.nextDouble();

                    System.out.print("Tiene remolque (true/false): ");
                    boolean remolque = teclado.nextBoolean();

                    Camion camion = new Camion(idCamion, batCamion, capCamion, remolque);

                    vehiculos.add(camion);

                    System.out.println("Camion agregado");

                    break;

                case 3:

                    if (vehiculos.size() == 0) {
                        System.out.println("No hay vehiculos");
                    } else {

                        for (int i = 0; i < vehiculos.size(); i++) {

                            System.out.println(vehiculos.get(i).descripcionTipo());
                            System.out.println(vehiculos.get(i));
                        }
                    }

                    break;
            }

        } while (opcion != 0);

    }

    public static void menuPuntos(Scanner teclado, ArrayList<PuntoDistribucion> puntos) {

        int opcion;

        do {

            System.out.println("----- PUNTOS -----");
            System.out.println("1. Registrar punto");
            System.out.println("2. Conectar puntos");
            System.out.println("3. Listar puntos");
            System.out.println("0. Volver");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = teclado.next();

                    System.out.print("Coordenada X: ");
                    double x = teclado.nextDouble();

                    System.out.print("Coordenada Y: ");
                    double y = teclado.nextDouble();

                    PuntoDistribucion punto = new PuntoDistribucion(nombre, x, y);

                    puntos.add(punto);

                    System.out.println("Punto agregado");

                    break;

                case 2:

                    if (puntos.size() == 0) {

                        System.out.println("No hay puntos");

                    } else {

                        for (int i = 0; i < puntos.size(); i++) {

                            puntos.get(i).setVisitado(true);

                            if (puntos.get(i).conectarALaRed()) {

                                System.out.println("Conectado: "
                                        + puntos.get(i).getNombreNodo());
                            }
                        }
                    }

                    break;

                case 3:

                    if (puntos.size() == 0) {

                        System.out.println("No hay puntos");

                    } else {

                        for (int i = 0; i < puntos.size(); i++) {
                            System.out.println(puntos.get(i));
                        }
                    }

                    break;
            }

        } while (opcion != 0);

    }

    public static void menuRepartidor(Scanner teclado,
            Repartidor sam,
            ArrayList<Vehiculo> vehiculos,
            ArrayList<PuntoDistribucion> puntos,
            ArrayList<Paquete> paquetes) {

        int opcion;

        do {

            System.out.println("----- REPARTIDOR -----");
            System.out.println("1. Equipar vehiculo");
            System.out.println("2. Viajar");
            System.out.println("3. Ver estado");
            System.out.println("4. Descansar");
            System.out.println("5. Cargar bateria");
            System.out.println("6. Simular carga");
            System.out.println("0. Volver");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    if (vehiculos.size() == 0) {

                        System.out.println("No hay vehiculos");

                    } else {

                        for (int i = 0; i < vehiculos.size(); i++) {
                            System.out.println(i + " - " + vehiculos.get(i));
                        }

                        System.out.print("Seleccione vehiculo: ");
                        int pos = teclado.nextInt();

                        if (pos >= 0 && pos < vehiculos.size()) {

                            sam.equiparVehiculo(vehiculos.get(pos));

                            System.out.println("Vehiculo equipado");
                        }
                    }

                    break;

                case 2:

                    if (puntos.size() == 0) {

                        System.out.println("No hay puntos");

                    } else {

                        for (int i = 0; i < puntos.size(); i++) {
                            System.out.println(i + " - "
                                    + puntos.get(i).getNombre());
                        }

                        System.out.print("Seleccione destino: ");
                        int destino = teclado.nextInt();

                        if (destino >= 0 && destino < puntos.size()) {

                            sam.viajarA(puntos.get(destino));

                            System.out.println("Viaje realizado");
                        }
                    }

                    break;

                case 3:

                    System.out.println(sam);

                    break;

                case 4:

                    sam.descansar();

                    System.out.println("Sam descanso");

                    break;

                case 5:

                    if (sam.getVehiculo() == null) {

                        System.out.println("Sam no tiene vehiculo");

                    } else {

                        System.out.print("Cantidad de carga: ");
                        double carga = teclado.nextDouble();

                        sam.getVehiculo().cargarBateria(carga);

                        System.out.println("Bateria cargada");
                    }

                    break;

                case 6:

                    if (paquetes.size() == 0) {

                        System.out.println("No hay paquetes");

                    } else {

                        for (int i = 0; i < paquetes.size(); i++) {
                            System.out.println(i + " - " + paquetes.get(i));
                        }

                        System.out.print("Seleccione paquete: ");
                        int posPaq = teclado.nextInt();

                        if (posPaq >= 0 && posPaq < paquetes.size()) {

                            if (sam.puedeCargar(paquetes.get(posPaq))) {

                                System.out.println("Sam puede transportar el paquete");

                            } else {

                                System.out.println("Sam NO puede transportar el paquete");
                            }
                        }
                    }

                    break;
            }

        } while (opcion != 0);

    }
}
