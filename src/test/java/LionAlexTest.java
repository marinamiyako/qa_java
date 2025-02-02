package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline feline;

    @Test
    public void getFriendsCorrect() throws Exception {
        List<String> expectedList = List.of(
                "Зебра Марти",
                "Бегемотиха Глория",
                "Жираф Мелман"
        );
        MatcherAssert.assertThat("Неправильный список друзей",
                new LionAlex(feline).getFriends(),
                equalTo(expectedList)
        );
    }

    @Test
    public void getNeverKittens() throws Exception{
        MatcherAssert.assertThat("У льва Алекса не бывает котят",
                new LionAlex(feline).getKittens(),
                equalTo(0)
        );
    }

    @Test
    public void getPlaceOfLivingCorrect() throws Exception {
        MatcherAssert.assertThat("Неправильно, Лев Алекс живет в другом месте",
                new LionAlex(feline).getPlaceOfLiving(),
                equalTo("Нью-Йоркский зоопарк")
        );
    }
}