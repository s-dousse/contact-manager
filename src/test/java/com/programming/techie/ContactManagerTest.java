package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ContactManagerTest {
    ContactManager contactManager;
    @BeforeAll
    public static void setUpAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Should Print Before Each Tests");
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Fist Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact(null,"Doe", "0123456789");
        });
        Assertions.assertEquals("First Name Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John",null, "0123456789");
        });
        Assertions.assertEquals("Last Name Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", null);
        });
        Assertions.assertEquals("Phone Number Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Too Short")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsTooShort() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "01234");
        });
        Assertions.assertEquals("Phone Number Should be 10 Digits Long", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Too Long")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsTooLong() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "012345678901011121314");
        });
        Assertions.assertEquals("Phone Number Should be 10 Digits Long", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number Does Not Only Contain Digits")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotOnlyContainDigits() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "01234ABCDE");
        });
        Assertions.assertEquals("Phone Number Contain only digits", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number Does Not Start with 0")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotStartWithZero() {
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "1234567890");
        });
        Assertions.assertEquals("Phone Number Should Start with 0", exception.getMessage());
    }

    @Test
    @DisplayName("Should Create Contact On MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled Only On MAC OS")
    public void shouldCreateContactOnlyOnMac() {
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Not Create Contact on Windows OS")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled on Windows OS")
    public void shouldNotCreateContactOnWindows() {
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Test Contact Creation on Developer Machine")
    public void shouldTestContactCreationOnDEV() {
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")));
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }


    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5,
        name = "Repeat Contact Creation Test {currentRepetition} of {totalRepetitions}" )
    public void shouldTestContactCreationRepeatedly() {
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @AfterAll
    public static void CleanUpAll() {
        System.out.println("Should Print After All Tests");
    }

    @AfterEach
    public void CleanUp() {
        System.out.println("Should Print After Each Tests");
    }
}