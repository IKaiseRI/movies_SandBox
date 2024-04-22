package com.example.movies_sandbox.entity;

import java.util.HashMap;
import java.util.Map;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private final String label;
    private static final Map<String, Rating> BY_LABEL = new HashMap<>();

    Rating(String label) {
        this.label = label;
    }

    static {
        for (Rating e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public static Rating valueOfLabel(String label){
        return BY_LABEL.get(label);
    }

    public static String valueOf(Rating rating) {
        return rating.toString();
    }
}
