package com.jayway.mshopelink.commons.valueobjects;

import java.util.Optional;
import java.util.regex.Pattern;

public record Media(String value) {
    private static final Pattern YOUTUBE_URL_PATTERN = Pattern.compile(
            "^(https?://)?(www\\.)?(youtube\\.com/watch\\?v=|youtu\\.be/)[\\w-]{11}$");

    private static final Pattern FIREBASE_URL_PATTERN = Pattern.compile(
            "^(https?://)?(\\w+\\.)?firebase(app)?(\\.com)?/.+$");

    public Media {
        ensureUrlIsValid(value);
    }

    private void ensureUrlIsValid(String value) {
        Optional.ofNullable(value)
                .filter(u -> u.startsWith("http://") || u.startsWith("https://"))
                .filter(u -> YOUTUBE_URL_PATTERN.matcher(u).matches() || FIREBASE_URL_PATTERN.matcher(u).matches())
                .orElseThrow(() -> new IllegalArgumentException("Media URL must be a valid YouTube or Firebase Storage URL"));
    }
}
