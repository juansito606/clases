import java.util.Scanner;

public class Amazon {

    private static Casillero[][] casilleros;
    private static int filas;
    private static int columnas;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        filas = leerEntero(sc, "Ingrese numero de FILAS:", 1, 20);
        columnas = leerEntero(sc, "Ingrese numero de COLUMNAS:", 1, 20);
        
        casilleros = new Casillero[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casilleros[i][j] = new Casillero();
            }
        }
        
        System.out.println(esquemaCasilleros());

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opcion:", 1, 4);

            if (opcion == 1) {
                System.out.println("--Registro de paquete--");
                System.out.print("Nombre del destinatario: ");
                sc.nextLine(); 
                String dest = sc.nextLine().trim();
                
                int f = leerEntero(sc, "Fila:", 0, filas - 1);
                int c = leerEntero(sc, "Columna:", 0, columnas - 1);

                boolean ok = registrarPaquete(f, c, dest);
                if (ok) {
                    System.out.println("[OK] Paquete registrado en [" + f + "," + c + "]");
                } else {
                    System.out.println("[Error] Casillero ocupado o coordenadas invalidas");
                }
                System.out.println(esquemaCasilleros());

            } else if (opcion == 2) {
                System.out.println("--Consulta de casilleros disponibles--");
                System.out.println(esquemaCasilleros());

            } else if (opcion == 3) {
                System.out.println("--Informacion de paquetes--");
                System.out.println(infoPaquetes());

            } else if (opcion == 4) {
                System.out.println("Cerrando aplicacion...");
            }
        } while (opcion != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=============");
        System.out.println("1. Registrar paquete");
        System.out.println("2. Consultar casilleros disponibles");
        System.out.println("3. Informacion de paquetes");
        System.out.println("4. Salir");
        System.out.println("=========");
    }

    private static int leerEntero(Scanner sc, String prompt, int min, int max) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print(prompt);
            String linea = sc.nextLine();
            try {
                valor = Integer.parseInt(linea);
                if (valor < min || valor > max) {
                    System.out.println("[Error] Ingrese un valor entre " + min + " y " + max);
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Ingrese un numero valido");
            }
        }
        return valor;
    }
    
    private static boolean registrarPaquete(int fila, int columna, String destinatario) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            Casillero casillero = casilleros[fila][columna];
            if (!casillero.estaOcupado()) {
                casillero.registrarPaquete(new Paquete(destinatario));
                return true;
            }
        }
        return false;
    }

    private static String esquemaCasilleros() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(casilleros[i][j].estaOcupado() ? "[X]" : "[ ]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String infoPaquetes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casillero casillero = casilleros[i][j];
                if (casillero.estaOcupado()) {
                    sb.append("Casillero [" + i + "," + j + "]: ");
                    // Aquí se accede a la información del paquete correctamente
                    sb.append("Paquete para " + casillero.getPaquete().getDestinatario());
                    sb.append(", Fecha de Ingreso: " + casillero.getPaquete().getFechaIngreso() + "\n");
                }
            }
        }
        return sb.toString();
    }
}