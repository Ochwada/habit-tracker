package com.habit_tracker;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: com.habit_tracker
 * File: HabitProcessorTest.java
 * Author: Ochwada
 * Date: Thursday, 12.Jun.2025, 3:13 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class HabitProcessorTest {

    private HabitProcessor processor;
    private List<Habit> habits;

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating HabitProcessor Tests...  ");
    }

    @BeforeEach
    void setUp() {
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");
        processor = new HabitProcessor();

        // Dummy habits
        habits = List.of(
                new Habit("Drink water", true, "Health"),
                new Habit("Morning run", false, "Fitness"),
                new Habit("Read a book", true, "Personal Development"),
                new Habit("Meditation", false, "Mindfulness"),
                new Habit("Call family", true, "Social")
        );
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  HabitProcessor ✨ Tests  Successfully Done ✨");
    }

// -----------------------------------------------------
// TESTS
// -----------------------------------------------------


    @Test
    @DisplayName("Test that the mapHabit() returns a list of names")
    public void mapHabitTest() {
        Function<Habit, String> nameMapper = Habit::getName;

        List<String> names = processor.mapHabits(habits, nameMapper);

        assertNotNull(names);
        assertEquals(habits.size(), names.size());
        assertTrue(names.contains("Drink water"));
        assertTrue(names.contains("Meditation"));

    }

    @Test
    @DisplayName("Test that filterHabits() returns only incomplete habits")
    void filterHabitsTest() {
        List<Habit> incompleteHabits = processor.filterHabits(
                habits, habit -> !habit.isCompletedToday());

        assertNotNull(incompleteHabits);
        assertEquals(2, incompleteHabits.size());
        assertTrue(incompleteHabits.stream().allMatch(h -> !h.isCompletedToday()));
    }

    @Test
    @DisplayName("Test that processHabits() performs an action (StringBuilder accumulation)")
    void processHabitsTest() {
        StringBuilder log = new StringBuilder();

        processor.processHabits(habits, habit -> log.append(habit.getName()).append(", "));

        String result = log.toString();

        assertTrue(result.contains("Drink water"));
        assertTrue(result.contains("Meditation"));
        assertTrue(result.contains("Call family"));
    }
}
