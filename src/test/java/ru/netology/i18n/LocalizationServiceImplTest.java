package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService  = new LocalizationServiceImpl();

    public static Stream<Arguments> testMessageByLocale() {
        return Stream.of(
                Arguments.of(Country.RUSSIA,"Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome"));
    }

    @ParameterizedTest
    @MethodSource
    void testMessageByLocale(Country country, String expected) {
        String actual = localizationService.locale(country);

        assertEquals(expected, actual);
    }
}