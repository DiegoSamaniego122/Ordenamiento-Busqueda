package controllers;

import models.Person;
import views.View;

public class Controller {

    private View view;
    private SortingMethods sort;
    private SearchMethods search;
    private Person[] persons = new Person[20];
    private int count = 0;

    public Controller(View v, SortingMethods s, SearchMethods se) {
        this.view = v;
        this.sort = s;
        this.search = se;
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1 -> inputPersons();
                case 2 -> addPersons();
                case 3 -> sortPersons();
                case 4 -> searchPerson();
                case 5 -> view.displayPersons(persons);
            }
        } while (option != 0);
    }

    public void inputPersons() {
        int n = view.inputNumberOfPersons();
        for (int i = 0; i < n; i++) {
            persons[count++] = view.inputPerson();
        }
    }

    public void addPersons() {
        persons[count++] = view.inputPerson();
    }

    public void sortPersons() {
        int op = view.selectSortingMethod();

        switch (op) {
            case 1 -> sort.sortByNameWithBubble(persons, count);
            case 2 -> sort.sortByNameWithSelectionDes(persons, count);
            case 3 -> sort.sortByAgeWithInsertion(persons, count);
            case 4 -> sort.sortByNameWithInsertion(persons, count);
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        System.out.println("Personas ordenadas correctamente.\n");
        view.displayPersons(persons); // <--- AQUÍ YA SE MUESTRA EL RESULTADO
    }

    public void searchPerson() {
        int op = view.selectSearchCriterion();

        if (op == 1) { // por edad
            if (!search.isSortedByAge(persons)) {
                System.out.println("No está ordenado por edad. Ordenando...");
                sort.sortByAgeWithInsertion(persons, count);
            }
            int age = view.inputAge();
            view.displaySearchResult(search.binarySearchByAge(persons, age));

        } else { // por nombre
            if (!search.isSortedByName(persons)) {
                System.out.println("No está ordenado por nombre. Ordenando...");
                sort.sortByNameWithInsertion(persons, count);
            }
            String name = view.inputName();
            view.displaySearchResult(search.binarySearchByName(persons, name));
        }
    }
}