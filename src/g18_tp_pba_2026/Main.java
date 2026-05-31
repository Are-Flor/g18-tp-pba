/* TEST TEST TEST
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *holaaaa
 */
package g18_tp_pba_2026;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paquete[] paquetes = new Paquete[50];
        int cantPaquetes = 0;

        Vehiculo[] vehiculos = new Vehiculo[50];
        int cantVehiculos = 0;

        PuntoDistribucion[] puntos = new PuntoDistribucion[50];
        int cantPuntos = 0;

        PuntoDistribucion central = new PuntoDistribucion("Central", 0, 0);
        central.setVisitado(true);
        puntos[cantPuntos] = central;
        cantPuntos++;

        Repartidor repartidor = new Repartidor("Sam", 15.0, central);

        String opcion;

        do {
            System.out.println("===============================");
            System.out.println(" BRIDGES DISTRIBUTION SYSTEM");
            System.out.println("===============================");
            System.out.println("1. Gestion de paquetes");
            System.out.println("2. Gestion de vehiculos");
            System.out.println("3. Gestion de puntos");
            System.out.println("4. Repartidor");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    cantPaquetes = menuPaquetes(sc, paquetes, cantPaquetes);
                    break;
                case "2":
                    cantVehiculos = menuVehiculos(sc, vehiculos, cantVehiculos);
                    break;
                case "3":
                    cantPuntos = menuPuntos(sc, puntos, cantPuntos);
                    break;
                case "4":
                    menuRepartidor(sc, repartidor, vehiculos, cantVehiculos, puntos, cantPuntos, paquetes, cantPaquetes);
                    break;
                case "0":
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese un numero del 0 al 4.");
            }

        } while (!opcion.equals("0"));
    }

    public static int menuPaquetes(Scanner sc, Paquete[] paquetes, int cantPaquetes) {
        String opcion;

        do {
            System.out.println("----- PAQUETES -----");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Clonar paquete");
            System.out.println("3. Listar paquetes");
            System.out.println("4. Ordenar paquetes");
            System.out.println("0. Volver");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (cantPaquetes >= paquetes.length) {
                        System.out.println("No hay espacio para mas paquetes.");
                    } else {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Descripcion: ");
                        String descripcion = sc.nextLine();

                        double peso = leerDoublePositivo(sc, "Peso: ");

                        boolean urgente = leerBooleanoConUnoCero(sc, "Urgente");

                        paquetes[cantPaquetes] = new Paquete(id, descripcion, peso, urgente);
                        cantPaquetes++;

                        System.out.println("Paquete agregado");
                    }
                    break;

                case "2":
                    if (cantPaquetes > 0) {
                        for (int i = 0; i < cantPaquetes; i++) {
                            System.out.println(i + " - " + paquetes[i]);
                        }

                        int pos = leerEntero(sc, "Seleccione posicion: ");

                        if (pos >= 0 && pos < cantPaquetes) {
                            if (cantPaquetes >= paquetes.length) {
                                System.out.println("No hay espacio en el arreglo para clonar.");
                            } else {
                                Paquete copia = paquetes[pos].clone();

                                System.out.print("Nuevo ID: ");
                                String nuevoId = sc.nextLine();

                                copia.setId(nuevoId);
                                paquetes[cantPaquetes] = copia;
                                cantPaquetes++;

                                System.out.println("Paquete clonado");
                            }
                        } else {
                            System.out.println("La posicion ingresada no existe");
                        }
                    } else {
                        System.out.println("No hay paquetes");
                    }
                    break;

                case "3":
                    if (cantPaquetes == 0) {
                        System.out.println("No hay paquetes");
                    } else {
                        for (int i = 0; i < cantPaquetes; i++) {
                            System.out.println(paquetes[i]);
                        }
                    }
                    break;

                case "4":
                    if (cantPaquetes == 0) {
                        System.out.println("No hay paquetes");
                    } else {
                        for (int i = 0; i < cantPaquetes - 1; i++) {
                            for (int j = 0; j < cantPaquetes - 1 - i; j++) {
                                if (paquetes[j].compareTo(paquetes[j + 1]) > 0) {
                                    Paquete aux = paquetes[j];
                                    paquetes[j] = paquetes[j + 1];
                                    paquetes[j + 1] = aux;
                                }
                            }
                        }

                        System.out.println("Paquetes ordenados:");
                        for (int i = 0; i < cantPaquetes; i++) {
                            System.out.println((i + 1) + ") " + paquetes[i]);
                        }

                        System.out.println("Paquetes ordenados por urgencia, peso e ID");
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (!opcion.equals("0"));

        return cantPaquetes;
    }

    public static int menuVehiculos(Scanner sc, Vehiculo[] vehiculos, int cantVehiculos) {
        String opcion;

        do {
            System.out.println("----- VEHICULOS -----");
            System.out.println("1. Registrar moto");
            System.out.println("2. Registrar camion");
            System.out.println("3. Listar vehiculos");
            System.out.println("0. Volver");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (cantVehiculos >= vehiculos.length) {
                        System.out.println("No hay espacio para mas vehiculos.");
                    } else {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        double bateriaMaxima = leerBateria(sc);

                        double capacidadCarga = leerDoublePositivo(sc, "Capacidad carga: ");

                        vehiculos[cantVehiculos] = new Moto(id, bateriaMaxima, capacidadCarga);
                        cantVehiculos++;

                        System.out.println("Moto agregada");
                    }
                    break;

                case "2":
                    if (cantVehiculos >= vehiculos.length) {
                        System.out.println("No hay espacio para mas vehiculos.");
                    } else {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        double bateriaMaxima = leerBateria(sc);

                        double capacidadCarga = leerDoublePositivo(sc, "Capacidad carga: ");

                        boolean tieneRemolque = leerBooleanoConUnoCero(sc, "Tiene remolque");

                        vehiculos[cantVehiculos] = new Camion(id, bateriaMaxima, capacidadCarga, tieneRemolque);
                        cantVehiculos++;

                        System.out.println("Camion agregado");
                    }
                    break;

                case "3":
                    if (cantVehiculos == 0) {
                        System.out.println("No hay vehiculos");
                    } else {
                        for (int i = 0; i < cantVehiculos; i++) {
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

        return cantVehiculos;
    }

    public static int menuPuntos(Scanner sc, PuntoDistribucion[] puntos, int cantPuntos) {
        String opcion;

        do {
            System.out.println("----- PUNTOS -----");
            System.out.println("1. Registrar punto");
            System.out.println("2. Conectar puntos");
            System.out.println("3. Listar puntos");
            System.out.println("0. Volver");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (cantPuntos >= puntos.length) {
                        System.out.println("No hay espacio para mas puntos.");
                    } else {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        double x = leerDouble(sc, "Coordenada X: ");
                        double y = leerDouble(sc, "Coordenada Y: ");

                        puntos[cantPuntos] = new PuntoDistribucion(nombre, x, y);
                        cantPuntos++;

                        System.out.println("Punto agregado");
                    }
                    break;

                case "2":
                    if (cantPuntos < 2) {
                        System.out.println("Debe haber al menos dos puntos para conectar.");
                    } else {
                        for (int i = 0; i < cantPuntos; i++) {
                            System.out.println(i + " - " + puntos[i].getNombre());
                        }

                        int origen = leerEntero(sc, "Seleccione punto origen: ");
                        int destino = leerEntero(sc, "Seleccione punto destino: ");

                        if (origen >= 0 && origen < cantPuntos && destino >= 0 && destino < cantPuntos) {
                            if (origen == destino) {
                                System.out.println("No puede conectar un punto consigo mismo.");
                            } else {
                                boolean conectadoOrigen = puntos[origen].conectarALaRed();
                                boolean conectadoDestino = puntos[destino].conectarALaRed();

                                if (conectadoOrigen && conectadoDestino) {
                                    System.out.println("Puntos conectados: " + puntos[origen].getNombre() + " - " + puntos[destino].getNombre());
                                } else {
                                    System.out.println("No se pudieron conectar los puntos.");
                                }
                            }
                        } else {
                            System.out.println("Opcion invalida.");
                        }
                    }
                    break;

                case "3":
                    if (cantPuntos == 0) {
                        System.out.println("No hay puntos");
                    } else {
                        for (int i = 0; i < cantPuntos; i++) {
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

        return cantPuntos;
    }

    public static void menuRepartidor(Scanner sc, Repartidor repartidor, Vehiculo[] vehiculos, int cantVehiculos,
                                      PuntoDistribucion[] puntos, int cantPuntos, Paquete[] paquetes, int cantPaquetes) {
        String opcion;
        Paquete paqueteSeleccionado = null;

        do {
            System.out.println("----- REPARTIDOR -----");
            System.out.println("1. Equipar vehiculo");
            System.out.println("2. Viajar");
            System.out.println("3. Ver estado");
            System.out.println("4. Descansar");
            System.out.println("5. Cargar bateria");
            System.out.println("6. Simular carga");
            System.out.println("0. Volver");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (cantVehiculos == 0) {
                        System.out.println("No hay vehiculos");
                    } else {
                        for (int i = 0; i < cantVehiculos; i++) {
                            System.out.println(i + " - " + vehiculos[i]);
                        }

                        int posVehiculo = leerEntero(sc, "Seleccione vehiculo: ");

                        if (posVehiculo >= 0 && posVehiculo < cantVehiculos) {
                            repartidor.equiparVehiculo(vehiculos[posVehiculo]);
                            System.out.println("Vehiculo equipado");
                        } else {
                            System.out.println("Opcion invalida.");
                        }
                    }
                    break;

                case "2":
                    if (repartidor.getVehiculo() == null) {
                        System.out.println("Debe seleccionar un vehiculo antes de viajar.");
                    } else if (paqueteSeleccionado == null) {
                        System.out.println("Debe seleccionar una carga antes de viajar.");
                    } else if (cantPuntos == 0) {
                        System.out.println("No hay puntos");
                    } else {
                        for (int i = 0; i < cantPuntos; i++) {
                            System.out.println(i + " - " + puntos[i].getNombre());
                        }

                        int destino = leerEntero(sc, "Seleccione destino: ");

                        if (destino >= 0 && destino < cantPuntos) {
                            boolean viajeRealizado = repartidor.viajarA(puntos[destino]);

                            if (viajeRealizado) {
                                System.out.println("Viaje realizado");
                            } else {
                                System.out.println("No se pudo realizar el viaje.");
                            }
                            } else {
                            System.out.println("Opcion invalida. No se realizo el viaje.");
                        }
                    }
                    break;

                case "3":
                    System.out.println(repartidor);
                    break;

                case "4":
                    repartidor.descansar();
                    System.out.println("Sam descanso");
                    break;

                case "5":
                    if (repartidor.getVehiculo() == null) {
                        System.out.println("Sam no tiene vehiculo");
                    } else {
                        System.out.println("Cargar bateria");
                        repartidor.getVehiculo().cargarBateria(100);
                        System.out.println("100% de bateria cargada para el vehiculo seleccionado");
                    }
                    break;

                case "6":
                    if (cantPaquetes == 0) {
                        System.out.println("No hay paquetes");
                    } else if (repartidor.getVehiculo() == null) {
                        System.out.println("Debe seleccionar un vehiculo antes de seleccionar una carga.");
                    } else {
                        for (int i = 0; i < cantPaquetes; i++) {
                            System.out.println(i + " - " + paquetes[i]);
                        }

                        int posPaquete = leerEntero(sc, "Seleccione paquete: ");

                        if (posPaquete >= 0 && posPaquete < cantPaquetes) {
                            if (repartidor.puedeCargar(paquetes[posPaquete])) {
                                paqueteSeleccionado = paquetes[posPaquete];
                                System.out.println("Sam puede transportar el paquete");
                                System.out.println("Carga seleccionada correctamente");
                            } else {
                                System.out.println("Sam NO puede transportar el paquete");
                            }
                        } else {
                            System.out.println("Opcion invalida.");
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

    public static int leerEntero(Scanner sc, String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);

            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();
                valido = true;
            } else {
                System.out.println("Opcion invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }

        return numero;
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);

            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                sc.nextLine();
                valido = true;
            } else {
                System.out.println("Opcion invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }

        return numero;
    }

    public static double leerDoublePositivo(Scanner sc, String mensaje) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);

            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                sc.nextLine();

                if (numero > 0) {
                    valido = true;
                } else {
                    System.out.println("El valor debe ser mayor a 0.");
                }
            } else {
                System.out.println("Opcion invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }

        return numero;
    }

    public static double leerBateria(Scanner sc) {
        double bateria = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Ingrese bateria maxima del vehiculo (1% - 100%): ");

            if (sc.hasNextDouble()) {
                bateria = sc.nextDouble();
                sc.nextLine();

                if (bateria > 0 && bateria <= 100) {
                    valido = true;
                } else {
                    System.out.println("Error: la bateria debe estar entre 1 y 100.");
                }
            } else {
                System.out.println("Opcion invalida. Debe ingresar un numero.");
                sc.nextLine();
            }
        }

        return bateria;
    }

    public static boolean leerBooleanoConUnoCero(Scanner sc, String mensaje) {
        int opcion = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje + " Si(1) / No(0): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1 || opcion == 0) {
                    valido = true;
                } else {
                    System.out.println("Opcion invalida. Debe ingresar 1 para Si o 0 para No.");
                }
            } else {
                System.out.println("Opcion invalida. Debe ingresar 1 para Si o 0 para No.");
                sc.nextLine();
            }
        }

        return opcion == 1;
    }
}