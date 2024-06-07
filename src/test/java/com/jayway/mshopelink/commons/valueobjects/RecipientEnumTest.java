package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RecipientEnumTest {

    @Test
    public void shouldContainAllDefinedValues() {
        assertEquals(2, RecipientEnum.values().length);
        assertTrue(EnumSet.allOf(RecipientEnum.class).containsAll(Set.of(
                RecipientEnum.MYSELF,
                RecipientEnum.ONG
        )));
    }

    @Test
    public void shouldGetEnumValueByName() {
        assertEquals(RecipientEnum.MYSELF, RecipientEnum.valueOf("MYSELF"));
        assertEquals(RecipientEnum.ONG, RecipientEnum.valueOf("ONG"));
    }

    @Test
    public void shouldConvertEnumToString() {
        assertEquals("MYSELF", RecipientEnum.MYSELF.toString());
        assertEquals("ONG", RecipientEnum.ONG.toString());
    }
}
