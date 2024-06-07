package com.jayway.mshopelink.modules.register_campaign.domain.valueobject;

import com.jayway.mshopelink.commons.valueobjects.Media;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MediaTest {
    @Test
    void shouldCreateMediaWithValidUrl() {
        // URL válida de YouTube
        Media mediaYoutubeShort = new Media("https://youtu.be/dQw4w9WgXcQ");
        Assertions.assertEquals("https://youtu.be/dQw4w9WgXcQ", mediaYoutubeShort.value());

        Media mediaYoutubeLong = new Media("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        Assertions.assertEquals("https://www.youtube.com/watch?v=dQw4w9WgXcQ", mediaYoutubeLong.value());

        // URL válida de Firebase
        Media mediaFirebaseApp = new Media("https://yourapp.firebaseapp.com/media");
        Assertions.assertEquals("https://yourapp.firebaseapp.com/media", mediaFirebaseApp.value());

        Media mediaFirebaseHosting = new Media("https://subdomain.firebaseapp.com/another-route");
        Assertions.assertEquals("https://subdomain.firebaseapp.com/another-route", mediaFirebaseHosting.value());
    }
    @Test
    void shouldThrowExceptionForInvalidUrl1() {
        Executable invalidMediaCreation = () -> new Media("https://invalidmedia.com/media");
        Assertions.assertThrows(IllegalArgumentException.class, invalidMediaCreation);
    }

    @Test
    void shouldThrowExceptionForInvalidUrl2() {
        Executable invalidMediaCreation = () -> new Media("yourapp.firebaseapp.com/media");
        Assertions.assertThrows(IllegalArgumentException.class, invalidMediaCreation);
    }

    @Test
    void shouldThrowExceptionForInvalidUrl3() {
        Executable invalidMediaCreation = () -> new Media("https://youtube.com/watch?v=invalidID");
        Assertions.assertThrows(IllegalArgumentException.class, invalidMediaCreation);
    }
}
