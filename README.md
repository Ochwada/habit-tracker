#  A real-life theme: Habit Tracker.


### Goal:
Create a simple Habit Tracker using Java Lambdas, Functional Interfaces, and Method References. 
You'll build a small functional engine to filter, transform, and process habits.

### Scenario:

You're building a Java app to manage personal habits. Each `Habit` has:
- A `name` (e.g., "Drink Water")
- A `completedToday` flag (boolean)
- A `category` (e.g., "Health", "Productivity")

##### You will:
- Filter out incomplete habits. 
- Extract their names using method references. 
- Print remaining habits using `Consumer`.

### Requirements:

1. Create a Maven project (habit-tracker)
2. Add JUnit 5 for testing in pom.xml 
3. Implement these classes:
   - `Habit`: immutable POJO with fields, constructor, getters, and toString()
   - `HabitProcessor`:
        - `List<Habit> filterHabits(List<Habit>, Predicate<Habit>)`
        - `List<String> mapHabits(List<Habit>, Function<Habit, String>)`
        - `void processHabits(List<Habit>, Consumer<Habit>)`
1. Write unit tests for each method using JUnit 5 
2. Create a `Demo` class with a `main()` method that:
   - Creates a list of at least 4 sample habits 
   - Filters only habits not yet completed 
   - Maps them to names
   - Prints each remaining habit with:
     - `"Don't forget: [habit details]"`

##### Output Example:
```java
Don't forget: Habit{name='Drink Water', completedToday=false, category='Health'}
Don't forget: Habit{name='Read a Book', completedToday=false, category='Growth'}
Habit Names: [Drink Water, Read a Book]
```
### Test Case Hint:

Test that your filter method returns only incomplete habits. Test that `mapHabits()` returns a list of names. 
And test that `processHabits()` performs an action (use `StringBuilder` or log accumulation).