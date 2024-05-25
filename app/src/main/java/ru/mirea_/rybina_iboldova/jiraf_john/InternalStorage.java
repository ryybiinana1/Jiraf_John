package ru.mirea_.rybina_iboldova.jiraf_john;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InternalStorage {

    private static final String USERS_FILE_NAME = "users.dat";
    private static final String UNIT_FILE_NAME = "unit.dat";
    private static final int REQUIRED_ANSWERS_COUNT = 0;

    private final Map<String, String> users;
    private final Map<Integer, Integer> unitAnswers;

    public InternalStorage() {
        users = loadUsers();
        unitAnswers = loadUnitAnswers();
        createFilesIfNotExist();
    }

    // Метод для загрузки пользователей из файла
    private Map<String, String> loadUsers() {
        Map<String, String> loadedUsers = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(USERS_FILE_NAME)))) {
            loadedUsers = (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Если файл не найден или возникла ошибка при чтении, возвращаем пустой список
            System.err.println("Failed to load users: " + e.getMessage());
        }
        return loadedUsers;
    }
    private void createFilesIfNotExist() {
        File usersFile = new File(USERS_FILE_NAME);
        File unitFile = new File(UNIT_FILE_NAME);
        try {
            if (!usersFile.exists()) {
                usersFile.createNewFile();
                System.out.println("Created users file: " + USERS_FILE_NAME);
            }
            if (!unitFile.exists()) {
                unitFile.createNewFile();
                System.out.println("Created unit file: " + UNIT_FILE_NAME);
            }
        } catch (IOException e) {
            System.err.println("Failed to create files: " + e.getMessage());
        }
    }

    // Метод для загрузки ответов unit из файла
    private Map<Integer, Integer> loadUnitAnswers() {
        Map<Integer, Integer> loadedUnitAnswers = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(UNIT_FILE_NAME)))) {
            loadedUnitAnswers = (Map<Integer, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Если файл не найден или возникла ошибка при чтении, возвращаем пустой список
            System.err.println("Failed to load unit answers: " + e.getMessage());
        }
        return loadedUnitAnswers;
    }

    // Метод для сохранения пользователей в файл
    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(USERS_FILE_NAME)))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Failed to save users: " + e.getMessage());
        }
    }

    // Метод для сохранения ответов unit в файл
    private void saveUnitAnswers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(UNIT_FILE_NAME)))) {
            oos.writeObject(unitAnswers);
        } catch (IOException e) {
            System.err.println("Failed to save unit answers: " + e.getMessage());
        }
    }

    // Метод для создания пользователя
    public void createUser(String login, String password) {
        users.put(login, password);
        saveUsers();
    }

    // Метод для входа пользователя
    public boolean loginUser(String login, String password) {
        return users.containsKey(login) && Objects.equals(users.get(login), password);
    }

    // Метод для добавления ответа в unit
    public void addAnswerToUnit(int unitNumber, int userId) {
        unitAnswers.put(unitNumber * 1000 + userId, unitAnswers.getOrDefault(unitNumber * 1000 + userId, 0) + 1);
        saveUnitAnswers();
    }

    // Метод для проверки прохождения unit
    public boolean checkUnitCompletion(int unitNumber, int userId) {
        return unitAnswers.getOrDefault(unitNumber * 1000 + userId, 0) >= REQUIRED_ANSWERS_COUNT;
    }
}
