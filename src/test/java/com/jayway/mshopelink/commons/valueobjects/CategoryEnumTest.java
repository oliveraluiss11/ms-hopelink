package com.jayway.mshopelink.commons.valueobjects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryEnumTest {
    @Test
    public void shouldContainAllDefinedCategories() {
        assertEquals(14, CategoryEnum.values().length);
        assertTrue(EnumSet.allOf(CategoryEnum.class).containsAll(Set.of(
                CategoryEnum.FAMILY,
                CategoryEnum.ANIMALS,
                CategoryEnum.COMMUNITY,
                CategoryEnum.SPORTS,
                CategoryEnum.EDUCATION,
                CategoryEnum.EMERGENCY,
                CategoryEnum.EVENTS,
                CategoryEnum.BUSINESS,
                CategoryEnum.RELIGION,
                CategoryEnum.HEALTH,
                CategoryEnum.TRAVELS,
                CategoryEnum.VOLUNTEERING,
                CategoryEnum.FUNERALS_AND_REMINDERS,
                CategoryEnum.COMPETITIONS
        )));
    }
    @Test
    public void shouldGetEnumValueByName() {
        assertEquals(CategoryEnum.FAMILY, CategoryEnum.valueOf("FAMILY"));
        assertEquals(CategoryEnum.ANIMALS, CategoryEnum.valueOf("ANIMALS"));
    }

    @Test
    public void shouldIterateOverEnumValues() {
        CategoryEnum[] categories = CategoryEnum.values();
        Set<CategoryEnum> categorySet = EnumSet.noneOf(CategoryEnum.class);
        categorySet.addAll(Arrays.asList(categories));
        assertEquals(EnumSet.allOf(CategoryEnum.class), categorySet);
    }

    @Test
    public void shouldConvertEnumToString() {
        assertEquals("FAMILY", CategoryEnum.FAMILY.toString());
        assertEquals("ANIMALS", CategoryEnum.ANIMALS.toString());
    }
}