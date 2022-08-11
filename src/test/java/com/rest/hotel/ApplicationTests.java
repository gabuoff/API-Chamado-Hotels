package com.rest.hotel;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import java.util.TimeZone;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class ApplicationTests {

    @InjectMocks
    private Application application;

    @Test
    void contextLoads() {
    }

    @Test
    @Tag("mutation")
    void postConstruct_withDefinedTimeZone_shouldRunSuccessfully() {

        //Arrange
        final String TIME_ZONE = "GMT-3";
        final TimeZone timeZone = TimeZone.getTimeZone(TIME_ZONE);

        ReflectionTestUtils.setField(application, "timeZone", TIME_ZONE);

        try(MockedStatic<TimeZone> response = mockStatic(TimeZone.class)) {

            response.when(() -> TimeZone.getTimeZone(any(String.class))).thenReturn(timeZone);

            //Act
            application.postConstruct();

            //Assertions
            response.verify(() -> TimeZone.setDefault(timeZone));
            response.verify(() -> TimeZone.getTimeZone(any(String.class)));

        }
    }
}