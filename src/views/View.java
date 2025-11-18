package views;

import java.util.Scanner;

import models.Person;

public class View {

    private Scanner sc = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Agregar persona");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar persona");
        System.out.println("5. Mostrar personas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Person inputPerson() {
        System.out.print("Ingrese nombre: ");
        String name = sc.next();
        System.out.print("Ingrese edad: ");
        int age = sc.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("\n--- MÉTODOS DE ORDENAMIENTO ---");
        System.out.println("1. Burbuja (Nombre)");
        System.out.println("2. Selección descendente (Nombre)");
        System.out.println("3. Inserción (Edad)");
        System.out.println("4. Inserción (Nombre)");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("\n--- CRITERIO DE BÚSQUEDA ---");
        System.out.println("1. Buscar por edad");
        System.out.println("2. Buscar por nombre");
        System.out.print("Seleccione: ");
        return sc.nextInt();
    }

    public int inputAge() {
        System.out.print("Ingrese edad a buscar: ");
        return sc.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese nombre a buscar: ");
        return sc.next();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("\n--- LISTA DE PERSONAS ---");
        for (Person p : persons) {
            if (p != null) System.out.println(p);
        }
    }

    public void displaySearchResult(Person p) {
        if (p == null) {
            System.out.println("No se encontró la persona.");
        } else {
            System.out.println("Persona encontrada: " + p);
        }
    }
    
    public int inputNumberOfPersons() {
    System.out.print("¿Cuántas personas desea ingresar? ");
    return sc.nextInt();
    }
}