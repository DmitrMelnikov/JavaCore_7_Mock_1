import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


class MessageSenderImplMock {
    @BeforeAll
    public static void before() {
        System.out.println("Тесты стартовали!");
    }

    @AfterAll
    public static void after() {
        System.out.println("Тесты закончены!");
    }

    @Test
    void test_get_send_massage_only_Russia() {

        LocalizationServiceImplMock localizationService = new LocalizationServiceImplMock();
        localizationService.setCountry(Country.RUSSIA);
        GeoServiceMock geoServiceMock = new GeoServiceMock();
        geoServiceMock.setLocation(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        geoServiceMock.byIp("172.0.32.11");

        MessageSender messageSender = new MessageSenderImpl(geoServiceMock, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        Assertions.assertEquals(messageSender.send(headers), "Добро пожаловать");
        System.out.println("");
    }

    @Test
    void test_get_send_massage_only_USA() {

        LocalizationServiceImplMock localizationService = new LocalizationServiceImplMock();
        localizationService.setCountry(Country.USA);
        GeoServiceMock geoServiceMock = new GeoServiceMock();
        geoServiceMock.setLocation(new Location("New York", Country.USA, " 10th Avenue", 32));
        geoServiceMock.byIp("96.44.183.149");

        MessageSender messageSender = new MessageSenderImpl(geoServiceMock, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        Assertions.assertEquals(messageSender.send(headers), "Welcome");
        System.out.println("");
    }


}
