package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void testSimpleFormat() {
        assertEquals("Smith, John",
                NameFormatter.format("John", "Smith"));
    }

    @Test
    void testFullFormat() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
    }

    @Test
    void testFullNameParsing() {
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format("Dr. Mel B Johnson, PhD"));
    }
}