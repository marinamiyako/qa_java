import com.example.Feline;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTest {

    @Test
    public void getFamilyCorrect() {
        String expectedFelineFamilyName = "Кошачьи";
        MatcherAssert.assertThat("Неправильное название семейства кошачьих",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyName)
        );
    }

    @Test
    public void eatMeatCorrect() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Неправильный список еды",
                feline.eatMeat(),
                equalTo(feline.getFood("Хищник"))
        );
    }

    @Test
    public void getKittensCount() {
        int expectedCount = 5;
        MatcherAssert.assertThat("Неправильное количество котят",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getKittensDefaultCount() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Неправильное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }
}
