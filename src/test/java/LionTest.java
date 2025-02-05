import com.example.Feline;
import com.example.Lion;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Mock
    Feline feline;

    @Test
    public void createLionThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самец или самка");

        new Lion(feline, "Не определено");
    }

    @Test
    public void getKittensIsCorrect() throws Exception{
        Lion lion = new Lion(feline, "Самец");
        int expectedCount = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Неправильное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getFoodForLion() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedListOfFood = List.of("Животные");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Неправильный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)

        );

    }

}
