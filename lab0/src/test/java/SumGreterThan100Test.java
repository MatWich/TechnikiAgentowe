import com.SumGreaterThan100;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumGreterThan100Test {
    SumGreaterThan100 ex;
    @BeforeEach
    void setup() {
        ex = new SumGreaterThan100();
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3"})
    void shouldReturnGivenNumber(int expected, int given) {
        int i = ex.returnInt(given);
        Assertions.assertEquals(expected, i);
    }
}