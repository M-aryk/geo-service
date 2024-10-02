package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {
    Map<String, String> headers = new HashMap<>();

    @Mock
    GeoServiceImpl geoService;
    @Mock
    LocalizationServiceImpl localizationService;

    @InjectMocks
    MessageSenderImpl messageSender;

    @Test
    void testSendRussian() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        when(localizationService.locale(any())).thenReturn("Добро пожаловать");
        when(geoService.byIp(anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, null,  0));
        String expected = "Добро пожаловать";

        String actual = messageSender.send(headers);

        assertEquals(expected,actual);
    }

    @Test
    void testSendAmerican() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        when(localizationService.locale(any())).thenReturn("Welcome");
        when(geoService.byIp(anyString())).thenReturn(new Location("New York", Country.USA, null,  0));
        String expected = "Welcome";

        String actual = messageSender.send(headers);

        assertEquals(expected,actual);
    }
}