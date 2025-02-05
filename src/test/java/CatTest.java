import com.example.Cat;
import com.example.Feline;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundForCat() {
        String expectedString = "Мяу";

        MatcherAssert.assertThat("Кот мяукает не так",
                new Cat(feline).getSound(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Неправильный список еды",
                cat.getFood(),
                equalTo(expectedListOfFood)

        );

    }

}
