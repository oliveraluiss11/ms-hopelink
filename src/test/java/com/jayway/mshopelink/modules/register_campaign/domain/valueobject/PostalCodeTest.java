package com.jayway.mshopelink.modules.register_campaign.domain.valueobject;

import com.jayway.mshopelink.commons.valueobjects.PostalCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostalCodeTest {
    @Test
    void shouldCreateWhenPostalCodeHas5NumberDigits() {
        var result = new PostalCode("01000");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("01000", result.value());
    }
    @Test
    void shouldNotCreateWhenPostalCodeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new PostalCode(null));
    }

    @Test
    void shouldNotCreateWhenPostalCodeIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new PostalCode(""));
    }

    @Test
    void shouldNotCreateWhenPostalCodeIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new PostalCode(" "));
    }

    @Test
    void shouldNotCreateWhenPostalCodeIsNotNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PostalCode("010A0"));
    }

    @Test
    void shouldNotCreateWhenPostalCodeGreaterThan5Digits() {
        assertThrows(IllegalArgumentException.class, () -> new PostalCode("010000"));
    }
}
