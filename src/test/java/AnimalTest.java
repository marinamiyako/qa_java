import com.example.Animal;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;

public class AnimalTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFamilyCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        MatcherAssert.assertThat("Неправильный список семейств",
                new Animal().getFamily(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        new Animal().getFood("");
    }
}