package ru.mirea_.rybina_iboldova.jiraf_john;

public class GlobalState {
    private static GlobalState instance;
    public int myAnswers;
    public int maxAnswers;

    public int userId;

    private GlobalState() {
        // Private constructor to prevent instantiation
    }
    public void setUserId(int user) {
        this.userId = user;
    }
    public static synchronized GlobalState getInstance() {
        if (instance == null) {
            instance = new GlobalState();
        }
        return instance;
    }

    public int addMyAnswers() {
        return myAnswers += 1;
    }
    public void setGlobalVariables(int max) {
        this.maxAnswers = max;

    }
    public void clearGlobalVariables() {
        this.maxAnswers = 0;
        this.myAnswers = 0;
    }
    public boolean checkTest() {
        return maxAnswers == myAnswers;
    }
}
