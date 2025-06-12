package com.habit_tracker;



/**
 * *******************************************************
 * Package: com.habit_tracker
 * File: Habit.java
 * Author: Ochwada
 * Date: Thursday, 12.Jun.2025, 2:17 PM
 * Description: Domain Modelling
 * Objective: Representing a habit in a habit tracker
 * *******************************************************
 */


public class Habit {
    private final String name;
    private final  boolean completedToday;
    private final String category;

    // Constructor
    public Habit(String name, boolean completedToday, String category) {
        this.name = name;
        this.completedToday = completedToday;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isCompletedToday() {
        return completedToday;
    }

    public String getCategory() {
        return category;
    }

    // to String conversion

    @Override
    public String toString() {
        return "Habit{" +
                "name='" + name + '\'' +
                ", completedToday=" + completedToday +
                ", category='" + category + '\'' +
                '}';
    }
}
