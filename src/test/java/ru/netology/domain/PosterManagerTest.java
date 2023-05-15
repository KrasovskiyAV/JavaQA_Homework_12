package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;
import javax.xml.stream.events.DTD;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {

    PosterManager poster = new PosterManager();

    @Test
    public void shouldAddMovieIfAddOne() {
        poster.addMovie("Movie_1");

        String[] expected = {"Movie_1"};
        String[] actual = poster.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieIfAddNotOne() {
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");

        String[] expected = {"Movie_1", "Movie_2", "Movie_3"};
        String[] actual = poster.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowIfEmpty() {

        String[] expected = {};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllIfOne() {
        poster.addMovie("Movie_1");

        String[] expected = {"Movie_1"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllIfAboveOne() {
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");

        String[] expected = {"Movie_1", "Movie_2", "Movie_3"};
        String[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastReversedIfAddOneIfDefaultLimit() {
        poster.addMovie("Movie_1");

        String[] expected = {"Movie_1"};
        String[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastReversedIfAddNotOneIfDefaultLimit() {
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");

        String[] expected = {"Movie_3", "Movie_2", "Movie_1"};
        String[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastReversedIfAddDefaultLimit() {
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");
        poster.addMovie("Movie_4");
        poster.addMovie("Movie_5");

        String[] expected = {"Movie_5", "Movie_4", "Movie_3", "Movie_2", "Movie_1"};
        String[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastReversedIfAddAboveDefaultLimit() {
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");
        poster.addMovie("Movie_4");
        poster.addMovie("Movie_5");
        poster.addMovie("Movie_6");

        String[] expected = {"Movie_6", "Movie_5", "Movie_4", "Movie_3", "Movie_2"};
        String[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastReversedIfNotDefaultLimit() {
        PosterManager poster = new PosterManager(7);
        poster.addMovie("Movie_1");
        poster.addMovie("Movie_2");
        poster.addMovie("Movie_3");
        poster.addMovie("Movie_4");
        poster.addMovie("Movie_5");
        poster.addMovie("Movie_6");
        poster.addMovie("Movie_7");
        poster.addMovie("Movie_8");

        String[] expected = {"Movie_8", "Movie_7", "Movie_6", "Movie_5", "Movie_4", "Movie_3", "Movie_2"};
        String[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }
}
