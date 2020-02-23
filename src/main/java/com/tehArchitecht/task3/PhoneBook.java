package com.tehArchitecht.task3;

// Класс для хранения номера телефона и информации об абоненте, добавлении,
// удалении или модицировании записи (телефонный справочник как консольное
// приложение).

import java.util.HashMap;
import java.util.Map;

public class PhoneBook <T> {
    private Map<String, T> columns = new HashMap<>();

    public boolean exists(String phoneNumber) {
        return columns.containsKey(phoneNumber);
    }

    public boolean add(String phoneNumber, T data) {
        if (exists(phoneNumber)) return false;

        columns.put(phoneNumber, data);
        return true;
    }

    public boolean delete(String phoneNumber) {
        if (!exists(phoneNumber)) return false;

        columns.remove(phoneNumber);
        return true;
    }

    public boolean modify(String phoneNumber, T newData) {
        if (!exists(phoneNumber)) return false;

        columns.replace(phoneNumber, newData);
        return true;
    }

    public T get(String phoneNumber) {
        return columns.get(phoneNumber);
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<String, T> entry : columns.entrySet()) {
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        if (result.isEmpty()) {
            return "Справочник пуст.";
        } else {
            return result.substring(0, result.length()-1);
        }
    }
}
