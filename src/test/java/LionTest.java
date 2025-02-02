package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeIsCorrect() throws Exception {
        MatcherAssert.assertThat("Грива есть только у льва",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );

    }

    @Test
    public void getFoodForLion() throws Exception {
        Lion lion = new Lion(feline, sex);
        List<String> expectedListOfFood = List.of("Животные");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Неправильный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)

        );

    }

}
