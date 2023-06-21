package ru.netology.manager;

import ru.netology.domain.Movie;

//import java.security.Provider;

public class PosterManager {

    private int resultLength; //желаемая длинна массива
    private Movie[] posters = new Movie[0];

    public PosterManager(int resultLength) {
        this.resultLength = resultLength;
    }

    public PosterManager() {

    }


    public void save(Movie poster) {
        Movie[] tmp = new Movie[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = poster;
        posters = tmp;
    }

    public Movie[] findAll() {
        return posters;
    }


    public Movie[] findLast() {
        int initialLength=5; // начальная длинна выводимого массива
        Movie[] tmp = findAll();
        int length = tmp.length;

        if (resultLength <= 0) {
            if (initialLength < length) {
                length = initialLength;
            }
        } else {
            if (resultLength < length) {
                length = resultLength;
            }

        }
        Movie[] result = new Movie[length];

        for (int i = 0; i < result.length; i++) {
            int index = tmp.length - i - 1;
            result[i] = tmp[index];
        }
        return result;
    }


}