import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceImplMock implements LocalizationService {
    private Country value;

    @Override
    public String locale(Country country) {
        switch (this.value) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }

    public void setCountry(Country value) {
        this.value = value;
    }
}
