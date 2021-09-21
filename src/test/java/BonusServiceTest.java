import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 7_503_60;
        boolean registered = false;
        long expected = 75;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 6_500_380_60;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}