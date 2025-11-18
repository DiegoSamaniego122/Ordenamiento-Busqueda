package controllers;

import models.Person;

public class SearchMethods {

    public boolean isSortedByAge(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].getAge() > arr[i + 1].getAge())
                return false;
        return true;
    }

    public boolean isSortedByName(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].getName().compareTo(arr[i + 1].getName()) > 0)
                return false;
        return true;
    }

    public Person binarySearchByAge(Person[] arr, int age) {
        int i = 0, f = arr.length - 1;
        while (i <= f) {
            int m = (i + f) / 2;
            if (arr[m].getAge() == age) return arr[m];
            else if (age < arr[m].getAge()) f = m - 1;
            else i = m + 1;
        }
        return null;
    }

    public Person binarySearchByName(Person[] arr, String name) {
        int i = 0, f = arr.length - 1;
        while (i <= f) {
            int m = (i + f) / 2;
            int cmp = name.compareTo(arr[m].getName());
            if (cmp == 0) return arr[m];
            else if (cmp < 0) f = m - 1;
            else i = m + 1;
        }
        return null;
    }
}