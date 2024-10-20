import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda{
    private ArrayList<Contacto> contactos;
    private int tamanoMaximo;

    public Agenda() {
        this.contactos = new ArrayList<>();
        this.tamanoMaximo = 10;
    }

    public Agenda(int tamanoMaximo) {
        this.contactos = new ArrayList<>();
        this.tamanoMaximo = tamanoMaximo;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public int getTamanoMaximo() {
        return tamanoMaximo;
    }

    public void setTamanoMaximo(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    public boolean agendaLlena(){
        return contactos.size() >= tamanoMaximo;
    }

    public void añadirContacto(Contacto nuevoContacto){
        if(agendaLlena()){
            System.out.println("Almacenamiento de agenda lleno");
        } else if (nuevoContacto.getNombre().isEmpty() || nuevoContacto.getApellido().isEmpty()){
            System.out.println("El nombre y/o apellido no pueden estar vacios");
        } else if (existeContacto(nuevoContacto)){
            System.out.println("Este contacto ya existe");
        } else {
            contactos.add(nuevoContacto);
            System.out.println("Contacto agregado con exito!");
        }
    }

    public boolean existeContacto(Contacto contacto){
        for (Contacto c : contactos) {
            if (c.contactoIgual(contacto)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarContactos(){
        if(contactos.isEmpty()){
            System.out.println("La agenda esta vacia");
        }
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        System.out.println("Contactos actuales: ");
        for (Contacto c: contactos){
           c.mostrarContacto();
        }
    }

    public void buscaContacto(String nombre, String apellido){
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono del contacto: " + c.getTelefono());
                return;
            }
        }
        System.out.println("El contacto no ha sido encontrado.");
    }

    public void eliminarContacto(String nombre, String apellido){
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                contactos.remove(c);
                System.out.println("Contacto Eliminado!");
                return;
            }
        }
        System.out.println("El contacto no ha sido encontrado.");
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Usuario modificado: " );
                c.mostrarContacto();
                return;
            }
        }
        System.out.println("El contacto no ha sido encontrado.");
    }

    public void espacioLibres(){
        int espaciosLibres = tamanoMaximo - contactos.size();
        System.out.println("Espacio disponible para " + espaciosLibres + " contactos mas");
    }
}
