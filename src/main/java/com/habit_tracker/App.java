package com.habit_tracker;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create an instance of HabitProcessor to access filtering functionality.
        HabitProcessor processor = new HabitProcessor();

        /**
         * Create a list of Habit objects
         * Each Habit contains
         * - a name (String)
         * - a completedToday status (boolean)
         * - a category (String)
         * */
        List<Habit> habits = List.of(
                new Habit("Drink water", true, "Health"),
                new Habit("Morning run", false, "Fitness"),
                new Habit("Meditation", false, "Mindfulness"),
                new Habit("Sleep 8 hours", true, "Health"),
                new Habit("Call family", true, "Social")
        );

        // ---------------------------------------------
        //1. Test filterHabits: only incomplete habits
        /**
         * Use HabitProcessor's filterHabits() method to filter habits that are not done.
         * The lambda expression: habit -> !habit.isCompletedToday().
         * - Reads as: "Keep habits where isCompletedToday() returns false".
         * The method returns a new list of pending habits
         * */
        List<Habit> pendingHabits = processor.filterHabits(
                habits, habit -> !habit.isCompletedToday()
        );

        List<Habit> doneHabits = processor.filterHabits(
                habits, Habit::isCompletedToday
        );

        System.out.println("\n----Incomplete Habits -----");
        // Option 1: Print all pending habits using stream
        /* processor.processHabits(pendingHabits,
                habit -> System.out.println("Don't forget: " + habit));*/

        // Option 2: Print all pending habits using stream

        processor.processHabits(pendingHabits,
                habit -> System.out.println("Don't forget: [" + habit.getName() + "]"));

        // ---------------------------------------------
        //2. Test mapHabits: return list of names
        List<String> allHabits = processor.mapHabits(habits, Habit::getName);
        System.out.println("\n--- All Habits ---");
        allHabits.forEach(System.out::println);

        // ---------------------------------------------
        //3. Test processHabits: accumulate names into StringBuilder
        StringBuilder accumulateNames = new StringBuilder();

        processor.processHabits(habits,
                habit -> accumulateNames.append(habit.getName()).append(" | "));

        System.out.println("\n* Accumulate Names output *");
        System.out.println(accumulateNames);

        // ---------------------------------------------
        //OTHERS. Test filterHabits: only COMPLETED habits
        System.out.println("\n=== Other outputs ===");
        // Option 1: Print all DONE habits using stream
        processor.processHabits(doneHabits,
                habit -> System.out.println("✅ Done: " + habit));

        // Option 2: Print all Done habits using stream
        System.out.println();
        processor.processHabits(doneHabits,
                habit -> System.out.println("✅ Done: [" + habit.getName() + "]"));
    }
}
