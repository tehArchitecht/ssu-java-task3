package com.tehArchitecht.task3;

// Написать программу для:
// 1. Сортировки ArrayList в порядке убывания.
// 2. Суммы элементов массива.
// 3. Проверки, содержит ли Map заданное значение, или нет.
// 4. Вставки элементов в начало и конец LinkedList.
// 5. Поиска элемента в ArrayList.
// 6. Хранения номера телефона и информации об абоненте, добавлении, удалении
//    или модицировании записи (телефонный справочник как консольное
//    приложение).

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Основная программа представляет собой телефонный справочник как консольное приложение.
        // Другие функции из задания проверяются в тестах.

        Scanner in = new Scanner(System.in);
        PhoneBook<String> phoneBook = new PhoneBook<String>();

        mainLoop:
        while (true) {
            System.out.println();
            System.out.println("Что бы вы хотели сделать? Введите один из вариантов [\"добавить\", \"удалить\", " +
                               "\"изменить\", \"вывести\", \"выйти\"]:");
            System.out.print("> ");

            String phoneNumber, data;
            String input = in.nextLine();
            switch (input) {
                case "добавить":
                    System.out.println("Введите телефон, запись о котором вы хотели бы добавить");
                    System.out.print("> ");

                    phoneNumber = in.nextLine();
                    if (phoneBook.exists(phoneNumber)) {
                        System.out.println("Ошибка. Запись с таким телефоном уже существует.");
                        continue;
                    }

                    System.out.println("Введите информацию об абоненте:");
                    System.out.print("> ");

                    data = in.nextLine();
                    phoneBook.add(phoneNumber, data);
                    break;
                case "удалить":
                    System.out.println("Введите телефон, запись о котором вы хотели бы удалить");
                    System.out.print("> ");

                    phoneNumber = in.nextLine();
                    if (phoneBook.delete(phoneNumber)) {
                        System.out.println("Запись удалена.");
                    } else {
                        System.out.println("Записи с таким телефоном не существует.");
                    }
                    break;
                case "изменить":
                    System.out.println("Введите телефон, запись о котором вы хотели бы изменить");
                    System.out.print("> ");

                    phoneNumber = in.nextLine();
                    if (!phoneBook.exists(phoneNumber)) {
                        System.out.println("Ошибка. Записи с таким телефоном не существует.");
                        continue;
                    }

                    System.out.println("Введите новую информацию:");
                    System.out.print("> ");

                    data = in.nextLine();
                    phoneBook.modify(phoneNumber, data);
                    break;
                case "вывести":
                    System.out.println(phoneBook);
                    break;
                case "выйти":
                    break mainLoop;
                default:
                    System.out.println("Ошибка. Команды \"" + input + "\" не существует.");
                    break;
            }
        }
    }

    // 1. Сортировка ArrayList в порядке убывания.
    public static void sortInReverseOrder(ArrayList list) {
        list.sort(Collections.reverseOrder());
    }

    // 2. Сумма элементов массива.
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // 3. Проверка, содержит ли Map заданное значение, или нет.
    public static boolean in(Object value, Map map) {
        return map.containsValue(value);
    }

    // 4. Вставка элементов в начало и конец LinkedList.
    public static <E> void insert(E element, LinkedList<E> list, InsertLocation location) {
        switch (location) {
            case Beginning:
                list.addFirst(element);
                break;
            case End:
                list.addLast(element);
                break;
        }
    }

    // 5. Поиск элемента в ArrayList.
    public static <E> int find(Object object, ArrayList<E> list) {
        return list.indexOf(object);
    }
}

enum InsertLocation {
    Beginning,
    End
}