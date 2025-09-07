public class  Paquete{
    int filas = leerEntero(sc,"Ingrese numero de FILAS:",1,20);
    int columnas =leerEntero(sc,"Ingrese numero de COLUMNAS:",1,20);


    OficinaCorreos oficina = new OficinaCorreos(filas,columnas);
    System.out.println(oficina.esquemaCasilleros());

    int opcion;
    do{
        mostrarMenu();
        opcion = leerEntero(sc, "Seleccione una opcion:", 1,4);

        if (opcion == 1) {
            System.out,println("--Registro de paquete--");
            Sytem.out.println("Nombre del destinatario:");
            String dest = sc.nextLine().trim();
            int f = leerEntero(sc, "Fila:", 0, filas -1);
            int c = leerEntero(sc,"Columna:", 0, columnas -1);

            boolean ok = oficina.registrarPaquete(f,c,dets);
            if(ok){
                System.out.println("[OK] Paquete registrado en [" + f + ","]")
            }
        }
    }

}