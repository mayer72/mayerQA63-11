package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;


public class PosterManagerTest {
    PosterManager repo = new PosterManager();
    Movie item1 = new Movie(1, "Bladshot", "http://", "actionMovie");
    Movie item2 = new Movie(2, "Ahead", "http://", "cartoon");
    Movie item3 = new Movie(3, "HotelBelgrad", "http://", "comedy");
    Movie item4 = new Movie(4, "Gentlemen", "http://", "actionMovie");
    Movie item5 = new Movie(5, "InvisibleMan", "http://", "horrors");
    Movie item6 = new Movie(6, "Trolls", "http://", "cartoon");
    Movie item7 = new Movie(7, "NumberOne", "http://", "comedy");

    @BeforeEach
    public void setup() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
    }

    @Test
    public void addMovieTest() {


        Movie[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    

    @Test
    public void givenLength() {


        Movie[] expected = {item7, item6, item5, item4, item3};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastTest() {
        PosterManager repo = new PosterManager(4);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);


        Movie[] expected = {item7, item6, item5, item4};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void minuszero() {
        PosterManager repo = new PosterManager(0);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);


        Movie[] expected = {item7, item6, item5, item4, item3};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void big() {
        PosterManager repo = new PosterManager(6);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);


        Movie[] expected = {item7, item6, item5, item4, item3,item2};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
