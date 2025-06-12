package com.habit_tracker;


import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * *******************************************************
 * Package: com.habit_tracker
 * File: HabitProcessor.java
 * Author: Ochwada
 * Date: Thursday, 12.Jun.2025, 2:24 PM
 * Description: Functional Engine
 * Objective:  Utility class - Processes a list of habits using functional programming constructs.
 * *******************************************************
 */


public class HabitProcessor {

    /**
     * Filters a list of habits based on  a provided condition.
     * <p>
     * This method applies the given {@link Predicate} to filter the provided list of {@link Habit} objects.
     * Only habits that match the condition (i.e. the predicate returns {@code true} will be included in the result.
     * <p>
     * * If {@code habits} is {@code null}, the method prints a message and returns an empty list.
     * * If {@code condition} is {@code null}, a {@link NullPointerException} is thrown.
     *
     * @param habits    the list of habits to be filtered; may be {@code null}.
     * @param condition the filtering condition to apply; must not be {@code null}.
     * @return a list of habits that satisfy the given condition; never {@code null}.
     * @throws NullPointerException if the condition is {@code null}.
     */
    public List<Habit> filterHabits(List<Habit> habits, Predicate<Habit> condition) {
        if (condition == null) {
            throw new NullPointerException(
                    "The condition should not be Null"
            );
        }

        if (habits == null) {
            System.out.println("There is no habits logged!");
            return List.of(); // Return empty list instead of asserting
        }

        return habits
                .stream()
                .filter(condition)
                ..toList();
    }

    /**
     * Transforms a list of habits into a list of strings using a provided mapping function.
     * <p>
     * This method applies the provided {@link Function} to each {@link Habit} object in the input list and returns a list
     * containing the resulting string values.
     * The mapping function defines how each habit should be converted into a string, allowing flexible extraction of habit information.
     *
     * @param habits      the list of habits to be transformed; must not be {@code null}.
     * @param habitMapper the function that maps each habit to a string; must not be {@code null}.
     * @return a list of strings produced by applying the mapping function to each habit; never {@code null}.
     * @throws NullPointerException if {@code habits} or {@code habitMapper} is {@code null}.
     */
    public List<String> mapHabits(List<Habit> habits, Function<Habit, String> habitMapper) {
        return habits
                .stream()
                .map(habitMapper)
                .toList();
    }

    /**
     * Processes each habit in the provided list by applying a specified action.
     * <p>
     * This method accepts a list of {@link Habit} objects and a {@link Consumer} functional interface that defines an
     * action to be performed on each task.
     *
     * @param habits the list of habits to process; must not be {@code null}.
     * @param action the action to be applied to each task; must not be {@code null}.
     * @throws NullPointerException if {@code habits} or {@code action} is {@code null}.
     */
    public void processHabits(List<Habit> habits, Consumer<Habit> action) {
        habits.forEach(action);
    }
}
