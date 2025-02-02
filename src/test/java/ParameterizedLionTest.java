package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public ParameterizedLionTest(String sex, boolean hasMane) {
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
        MatcherAssert.assertThat("Только у льва есть грива",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );

    }

}
