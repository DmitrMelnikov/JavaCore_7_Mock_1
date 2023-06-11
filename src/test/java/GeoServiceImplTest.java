import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

class GeoServiceImplTest {

    @BeforeAll
    public static void before() {
        System.out.println("Тест определения локации по IP стартовал!");
    }

    @AfterAll
    public static void after() {
        System.out.println("Тест определения локации по IP стоп!");
    }

    @Test
    void test_geo_location_byIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.13");
        String[] arrayTest = {"Moscow", Country.RUSSIA.toString(), null, "0"};
        String[] arraylocation = {location.getCity().toString(), location.getCountry().toString(), location.getStreet(), Integer.toString(location.getBuiling())};
        Assertions.assertArrayEquals(arraylocation, arrayTest);

    }
}
