import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.println("¿Definir tamaño de agenda? si o no ");
        String tamanoAgenda = scanner.nextLine();

        Agenda nuevaAgenda;
        if(tamanoAgenda.equalsIgnoreCase("si")){
            System.out.println("Ingrese el tamaño de agenda deseado: ");
            int tamanoSeleccionado = scanner.nextInt();
            nuevaAgenda = new Agenda(tamanoSeleccionado);
        } else {
            nuevaAgenda = new Agenda();
        }

        boolean salir = true;
        while(salir){
            System.out.println("Agenda Waldaz, getiona tus contactos");
            System.out.println("1. Agregar contactos");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar telefono");
            System.out.println("6. Verificar almacenamiento de agenda");
            System.out.println("7. Mostrar almacenamiento disponible");
            System.out.println("8. Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingresa el telefono: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
                    nuevaAgenda.añadirContacto(nuevoContacto);
                    break;
                case 2:
                    nuevaAgenda.mostrarContactos();
                    break;
                case 3:
                    System.out.println("Ingresa el nombre buscado: ");
                    String nombreBuscado = scanner.nextLine();
                    System.out.println("Ingresa el apellido buscado: ");
                    String apellidoBuscado = scanner.nextLine();
                    nuevaAgenda.buscaContacto(nombreBuscado, apellidoBuscado);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre a eliminar: ");
                    String nombreElimar = scanner.nextLine();
                    System.out.println("Ingrese el apellido a eliminar: ");
                    String apellidoElimanar = scanner.next();
                    nuevaAgenda.eliminarContacto(nombreElimar, apellidoElimanar);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    String apellidoModificar = scanner.nextLine();
                    System.out.println("Ingrese el número de telefono: ");
                    String telefonoModificar = scanner.nextLine();
                    nuevaAgenda.modificarTelefono(nombreModificar, apellidoModificar, telefonoModificar);
                    break;
                case 6:
                    if (nuevaAgenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 7:
                    nuevaAgenda.espacioLibres();
                    break;
                case 8:
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }
}