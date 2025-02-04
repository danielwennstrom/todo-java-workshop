package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Person;
import org.example.model.TodoItem;
import org.example.model.TodoItemTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MainTest {
    private Person person;
    private LocalDate today;

    @BeforeEach
    public void setUp() {
         person = new Person(1, "Sven", "Svensson", "test@domain.com");
         today = LocalDate.now();
    }

    @Test
    @DisplayName("Test Person")
    void testPerson() {
        Person person = new Person(1, "Sven", "Svensson", "test@domain.com");

        assertEquals("Sven Svensson", String.format("%s %s", person.getFirstName(), person.getLastName()));
        assertEquals("test@domain.com", person.getEmail());
    }

    @Test
    @DisplayName("Test TodoItem")
    void testTodoItem() {
        LocalDate yesterday = today.minusDays(1);
        TodoItem todoItem = new TodoItem(1, "Buy groceries",
                "Go to the store and buy groceries", yesterday, false, person);

        assertEquals("Buy groceries", todoItem.getTitle());
        assertEquals("Go to the store and buy groceries", todoItem.getTaskDescription());
        assertEquals(yesterday, todoItem.getDeadLine());
        assertTrue(todoItem.isOverdue());
        assertFalse(todoItem.isDone());
        assertSame(person, todoItem.getCreator());
    }

    @Test
    @DisplayName("Test TodoItemTask")
    void testTodoItemTask() {
        TodoItem todoItem = new TodoItem(1, "Buy groceries",
                "Go to the store and buy groceries", today, false, person);
        TodoItemTask task = new TodoItemTask(1, todoItem, person);

        assertEquals("Buy groceries", task.getTodoItem().getTitle());
        assertTrue(task.isAssigned());
        assertSame(person, task.getAssignee());
    }
}
