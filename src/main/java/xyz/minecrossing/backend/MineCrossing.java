package xyz.minecrossing.backend;

import com.google.gson.Gson;

public class MineCrossing {

    private static final Gson GSON = new Gson();

    private static MineCrossing instance;

    public static MineCrossing getInstance() {
        if (instance == null) instance = new MineCrossing();
        return instance;
    }

    public Gson getGSON() {
        return GSON;
    }
}
