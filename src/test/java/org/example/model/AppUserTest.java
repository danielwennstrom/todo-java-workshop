package org.example.model;

import org.example.util.AppRole;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppUserTest {

    private AppUser user;

    @BeforeEach
    public void setUp() {
        user = new AppUser("username", "password", AppRole.ROLE_APP_USER);
    }

    @Test
    @DisplayName("AppUser initialization")
    public void testAppUserInitialization() {
        assertNotNull(user);
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals(AppRole.ROLE_APP_USER, user.getRole());
    }

    @Test
    @DisplayName("setUsername with valid username")
    public void testSetUsernameWithValidUsername() {
        user.setUsername("new_username");
        assertEquals("new_username", user.getUsername());
    }

    @Test
    @DisplayName("setUsername with empty username")
    public void testSetUsernameWithEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
    }

    @Test
    @DisplayName("setUsername with null username")
    public void testSetUsernameWithNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null));
    }

    @Test
    @DisplayName("setPassword with valid password")
    public void testSetPasswordWithValidPassword() {
        user.setPassword("new_password");
        assertEquals("new_password", user.getPassword());
    }

    @Test
    @DisplayName("setPassword with empty password")
    public void testSetPasswordWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
    }

    @Test
    @DisplayName("setPassword with null password")
    public void testSetPasswordWithNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
    }

    @Test
    @DisplayName("setRole with valid role")
    public void testSetRoleWithValidRole() {
        user.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN, user.getRole());
    }
}