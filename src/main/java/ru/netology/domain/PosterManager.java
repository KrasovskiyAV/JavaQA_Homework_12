package ru.netology.domain;

public class PosterManager {

    private String nameMovie;
    private String[] allMovies = new String[0];
    private int defaultLimit = 5;

    public PosterManager() {
        this.defaultLimit = defaultLimit;
    }

    public PosterManager(int limit) {
        this.defaultLimit = limit;
    }

    public void addMovie(String newMovie) {
        String[] tmp = new String[allMovies.length + 1];
        for (int i = 0; i < allMovies.length; i++) {
            tmp[i] = allMovies[i];
        }
        tmp[tmp.length - 1] = newMovie;
        allMovies = tmp;
    }

    public String[] findAll() {
        return allMovies;
    }

    public String[] findLast() {
        int resultLength;
        if (allMovies.length < defaultLimit) {
            resultLength = allMovies.length;
        } else {
            resultLength = defaultLimit;
        }
        String[] result = new String[resultLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = allMovies[allMovies.length - 1 - i];
        }
        return result;
    }
}
