/* TEST TEST TEST
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *holaaaa
 */
package g18_tp_pba_2026;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Paquete[] paquetes = new Paquete[50];
        int contPaquetes = 0;

        Vehiculo[] vehiculos = new Vehiculo[50];
        int contVehiculos = 0;

        PuntoDistribucion[] puntos = new PuntoDistribucion[50];
        int contPuntos = 0;

        PuntoDistribucion base = new PuntoDistribucion("Central", 0, 0);
        puntos[contPuntos] = base;
        contPuntos++;

        Repartidor sam = new Repartidor("Sam", 15, base);

        String opcion;

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

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    contPaquetes = menuPaquetes(teclado, paquetes, contPaquetes);
                    break;

                case "2":
                    contVehiculos = menuVehiculos(teclado, vehiculos, contVehiculos);
                    break;

                case "3":
                    contPuntos = menuPuntos(teclado, puntos, contPuntos);
                    break;

                case "4":
                    menuRepartidor(teclado, sam, vehiculos, contVehiculos, puntos, contPuntos, paquetes, contPaquetes);
                    break;

                case "0":
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor, ingrese un numero del 0 al 4.");
            }

        } while (!opcion.equals("0"));
    }

    public static int menuPaquetes(Scanner teclado, Paquete[] paquetes, int contPaquetes) {
        String opcion;
        do {
            System.out.println("----- PAQUETES -----");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Clonar paquete");
            System.out.println("3. Listar paquetes");
            System.out.println("4. Ordenar paquetes");
            System.out.println("0. Volver");

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    if (contPaquetes >= paquetes.length) {
                        System.out.println("No hay espacio para mas paquetes.");
                        break;
                    }
                    
                    System.out.print("ID: ");
                    String id = teclado.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = teclado.nextLine();

                    System.out.print("Peso: ");
                    double peso = teclado.nextDouble();

                    System.out.print("Urgente (true/false): ");
                    boolean urgente = teclado.nextBoolean();
                    teclado.nextLine();

                    paquetes[contPaquetes] = new Paquete(id, descripcion, peso, urgente);
                    contPaquetes++;
                    System.out.println("Paquete agregado");
                    break;

                case "2":
                    if (contPaquetes > 0) {
                        for (int i = 0; i < contPaquetes; i++) {
                            System.out.println(i + " - " + paquetes[i]);
                        }

                        System.out.print("Seleccione posicion: ");
                        int pos = teclado.nextInt();
                        teclado.nextLine();

                        if (pos >= 0 && pos < contPaquetes) {
                            if (contPaquetes >= paquetes.length) {
                                System.out.println("No hay espacio en el arreglo para clonar.");
                                break;
                            }
                            
                            Paquete clon = paquetes[pos].clone();

                            System.out.print("Nuevo ID: ");
                            String nuevoId = teclado.nextLine();
                            clon.setId(nuevoId);

                            paquetes[contPaquetes] = clon;
                            contPaquetes++;
                            System.out.println("Paquete clonado");
                            
                        } else {
                            System.out.println("La posicion ingresada no existe");
                        }
                        
                    } else {
                        System.out.println("No hay paquetes");
                    }
                    
                    break;

                case "3":
                    if (contPaquetes == 0) {
                        System.out.println("No hay paquetes");
                        
                    } else {
                        for (int i = 0; i < contPaquetes; i++) {
                            System.out.println(paquetes[i]);
                        }
                    }
                    
                    break;
                    
                case "4":
                    for (int i = 0; i < contPaquetes - 1; i++) {
                        
                        for (int j = 0; j < contPaquetes - i - 1; j++) {
                            
                            if (paquetes[j].compareTo(paquetes[j + 1]) > 0) {
                                Paquete aux = paquetes[j];
                                paquetes[j] = paquetes[j + 1];
                                paquetes[j + 1] = aux;
                            }
                        }
                    }
                    System.out.println("Paquetes ordenados por urgencia, peso e ID");
                    break;
                
                case "0":
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (!opcion.equals("0"));

        return contPaquetes;
    }

    public static int menuVehiculos(Scanner teclado, Vehiculo[] vehiculos, int contVehiculos) {
        String opcion;
        do {
            System.out.println("----- VEHICULOS -----");
            System.out.println("1. Registrar moto");
            System.out.println("2. Registrar camion");
            System.out.println("3. Listar vehiculos");
            System.out.println("0. Volver");

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    if (contVehiculos >= vehiculos.length) {
                        System.out.println("No hay espacio para mas vehiculos.");
                        break;
                    }
                    System.out.print("ID: ");
                    String idMoto = teclado.next();

                    System.out.print("Bateria maxima: ");
                    double batMoto = teclado.nextDouble();

                    System.out.print("Capacidad carga: ");
                    double capMoto = teclado.nextDouble();
                    teclado.nextLine(); // Limpieza

                    vehiculos[contVehiculos] = new Moto(idMoto, batMoto, capMoto);
                    contVehiculos++;
                    System.out.println("Moto agregada");
                    break;

                case "2":
                    if (contVehiculos >= vehiculos.length) {
                        System.out.println("No hay espacio para mas vehiculos.");
                        break;
                    }
                    System.out.print("ID: ");
                    String idCamion = teclado.next();

                    System.out.print("Bateria maxima: ");
                    double batCamion = teclado.nextDouble();

                    System.out.print("Capacidad carga: ");
                    double capCamion = teclado.nextDouble();

                    System.out.print("Tiene remolque (true/false): ");
                    boolean remolque = teclado.nextBoolean();
                    teclado.nextLine(); // Limpieza

                    vehiculos[contVehiculos] = new Camion(idCamion, batCamion, capCamion, remolque);
                    contVehiculos++;
                    System.out.println("Camion agregado");
                    break;

                case "3":
                    if (contVehiculos == 0) {
                        System.out.println("No hay vehiculos");
                    } else {
                        for (int i = 0; i < contVehiculos; i++) {
                            System.out.println(vehiculos[i].descripcionTipo());
                            System.out.println(vehiculos[i]);
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (!opcion.equals("0"));

        return contVehiculos;
    }

    public static int menuPuntos(Scanner teclado, PuntoDistribucion[] puntos, int contPuntos) {
        String opcion;
        do {
            System.out.println("----- PUNTOS -----");
            System.out.println("1. Registrar punto");
            System.out.println("2. Conectar puntos");
            System.out.println("3. Listar puntos");
            System.out.println("0. Volver");

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    if (contPuntos >= puntos.length) {
                        System.out.println("No hay espacio para mas puntos.");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = teclado.next();

                    System.out.print("Coordenada X: ");
                    double x = teclado.nextDouble();

                    System.out.print("Coordenada Y: ");
                    double y = teclado.nextDouble();
                    teclado.nextLine();

                    puntos[contPuntos] = new PuntoDistribucion(nombre, x, y);
                    contPuntos++;
                    System.out.println("Punto agregado");
                    break;

                case "2":
                    if (contPuntos == 0) {
                        System.out.println("No hay puntos");
                        
                    } else {
                        
                        for (int i = 0; i < contPuntos; i++) {
                            if (puntos[i].conectarALaRed()) {
                                System.out.println("Conectado: " + puntos[i].getNombreNodo());
                            }
                        }
                    }
                    break;

                case "3":
                    if (contPuntos == 0) {
                        System.out.println("No hay puntos");
                    } else {
                        for (int i = 0; i < contPuntos; i++) {
                            System.out.println(puntos[i]);
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (!opcion.equals("0"));

        return contPuntos;
    }

    public static void menuRepartidor(Scanner teclado,
            Repartidor sam,
            Vehiculo[] vehiculos, int contVehiculos,
            PuntoDistribucion[] puntos, int contPuntos,
            Paquete[] paquetes, int contPaquetes) {

        String opcion;
        do {
            System.out.println("----- REPARTIDOR -----");
            System.out.println("1. Equipar vehiculo");
            System.out.println("2. Viajar");
            System.out.println("3. Ver estado");
            System.out.println("4. Descansar");
            System.out.println("5. Cargar bateria");
            System.out.println("6. Simular carga");
            System.out.println("0. Volver");

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    if (contVehiculos == 0) {
                        System.out.println("No hay vehiculos");
                    } else {
                        for (int i = 0; i < contVehiculos; i++) {
                            System.out.println(i + " - " + vehiculos[i]);
                        }
                        System.out.print("Seleccione vehiculo: ");
                        int pos = teclado.nextInt();
                        teclado.nextLine();

                        if (pos >= 0 && pos < contVehiculos) {
                            sam.equiparVehiculo(vehiculos[pos]);
                            System.out.println("Vehiculo equipado");
                        }
                    }
                    break;

                case "2":
                    if (contPuntos == 0) {
                        System.out.println("No hay puntos");
                    } else {
                        for (int i = 0; i < contPuntos; i++) {
                            System.out.println(i + " - " + puntos[i].getNombre());
                        }
                        System.out.print("Seleccione destino: ");
                        int destino = teclado.nextInt();
                        teclado.nextLine();

                        if (destino >= 0 && destino < contPuntos) {
                            sam.viajarA(puntos[destino]);
                            System.out.println("Viaje realizado");
                        }
                    }
                    break;

                case "3":
                    System.out.println(sam);
                    break;

                case "4":
                    sam.descansar();
                    System.out.println("Sam descanso");
                    break;

                case "5":
                    if (sam.getVehiculo() == null) {
                        System.out.println("Sam no tiene vehiculo");
                        
                    } else {
                        System.out.print("Cantidad de carga: ");
                        double carga = teclado.nextDouble();
                        teclado.nextLine();

                        sam.getVehiculo().cargarBateria(carga);
                        System.out.println("Bateria cargada");
                    }
                    break;

                case "6":
                    if (contPaquetes == 0) {
                        System.out.println("No hay paquetes");
                        
                    } else {
                        for (int i = 0; i < contPaquetes; i++) {
                            System.out.println(i + " - " + paquetes[i]);
                        }
                        
                        System.out.print("Seleccione paquete: ");
                        int posPaq = teclado.nextInt();
                        teclado.nextLine();

                        if (posPaq >= 0 && posPaq < contPaquetes) {
                            if (sam.puedeCargar(paquetes[posPaq])) {
                                System.out.println("Sam puede transportar el paquete");
                                
                            } else {
                                System.out.println("Sam NO puede transportar el paquete");
                            }
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (!opcion.equals("0"));
    }
}
