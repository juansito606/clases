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
                System.out.println("[OK] Paquete registrado en [" + f + ","+ c +"]");
            }else {
                System.out,println("[Error] Casillero ocupado o cordonadas invalidas");
            }
           System.out.println(oficina.esquemaCasilleros());
           
        } else if (opcion == 2) {
            System.out.println("--Consulta de casilleros disponibles--");
            System.out.println(oficina.esquemaCasilleros());

        }else if (opcion == 3) {
            System.out,println("--Informacion de paquetes--");
            System.out.println(oficina.infoPaquetes());

        }else if (opcion == 4) {
            System.out.println("Cerrando aplicacion...");

        }
        

    } while (opcion ! =4);

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
private static int  leerEntero (Scanner sc, String prompt, int min, int max) {
    int valor = -1;
    boolean valido = false;
    while (!valido){
        System.out.print(prompt);
        String linea = sc.nextLine();
        try{
            valor = Interger.parseInt(linea);
            if (valor < min || valor > max) {
                System.out.println("[Error]Ingrese un valor entre" + min + "y" + max);    
            }else {
                valido = true;
            }
        }catch (NumberFormatException e) {
            System.out.println("[Error] Ingrese un numero valido");
        }
    }
    return valor;
}