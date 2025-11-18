package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (arr[j].getName().compareTo(arr[j + 1].getName()) > 0) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameWithSelectionDes(Person[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (arr[j].getName().compareTo(arr[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            Person temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    public void sortByAgeWithInsertion(Person[] arr, int count) {
        for (int i = 1; i < count; i++) {
            Person key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getAge() > key.getAge()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void sortByNameWithInsertion(Person[] arr, int count) {
        for (int i = 1; i < count; i++) {
            Person key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getName().compareTo(key.getName()) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}