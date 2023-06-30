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
        Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact(null,"Doe", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create A Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John",null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create A Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows( RuntimeException.class, () -> {
            contactManager.addContact("John","Doe", null);
        });
    }
}