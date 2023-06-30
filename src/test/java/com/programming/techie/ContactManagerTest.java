package com.programming.techie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactManagerTest {
    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John","Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Fist Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact(null,"Doe", "0123456789");
        });
        Assertions.assertEquals("First Name Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John",null, "0123456789");
        });
        Assertions.assertEquals("Last Name Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", null);
        });
        Assertions.assertEquals("Phone Number Cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Too Short")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsTooShort() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "01234");
        });
        Assertions.assertEquals("Phone Number Should be 10 Digits Long", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Too Long")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsTooLong() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "012345678901011121314");
        });
        Assertions.assertEquals("Phone Number Should be 10 Digits Long", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number Does Not Only Contain Digits")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotOnlyContainDigits() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "01234ABCDE");
        });
        Assertions.assertEquals("Phone Number Contain only digits", exception.getMessage());
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number Does Not Start with 0")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberDoesNotStartWithZero() {
        ContactManager contactManager = new ContactManager();
        RuntimeException exception = Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", "1234567890");
        });
        Assertions.assertEquals("Phone Number Should Start with 0", exception.getMessage());
    }
}