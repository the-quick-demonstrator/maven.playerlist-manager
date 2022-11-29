package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/2021.
 */
public class GetMinimumNumberOfStepsBetweenTest {

    private void test(String[] songArray, int startingIndex, int desiredSongIndex, Integer expected) {
        // given
        Playlist music = new Playlist(songArray);
        String desiredSong = songArray[desiredSongIndex];

        // when
        Integer actual = music.getMinimumNumberOfStepsBetween(startingIndex, desiredSong);

        // then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test1() {
        // given
        String[] playlist = {"wheniseeyouagain", "borntorun", "nothingelsematters", "cecelia"};
        int desiredSongIndex = 3;
        int startingIndex = 1;
        int expected = 2;
        test(playlist, desiredSongIndex, startingIndex, expected);
    }


    @Test
    public void test2() {
        // given
        String[] playlist = {"wheniseeyouagain", "borntorun", "nothingelsematters", "cecelia"};
        int desiredSongIndex = 2;
        int startingIndex = 1;
        int expected = 1;
        test(playlist, desiredSongIndex, startingIndex, expected);
    }

    @Test
    public void test3() {
        // given
        String[] playlist = {"dancinginthedark", "rio", "liveoak", "liveoak"};
        int desiredSongIndex = 2;
        int startingIndex = 1;
        int expected = 1;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }



    @Test
    public void test4() {
        // given
        String[] playlist = {"dancinginthedark", "rio", "liveoak", "liveoak"};
        int desiredSongIndex = 1;
        int startingIndex = 0;
        int expected = 1;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }

    @Test
    public void test5() {
        // given
        String[] playlist = {"dancinginthedark", "rio", "liveoak", "liveoak"};
        int desiredSongIndex = 1;
        int startingIndex = 3;
        int expected = 1;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }

    @Test
    public void test6() {
        // given
        String[] playlist = {"The", "Quick", "Brown", "Fox", "Jumps", "Over", "The", "Lazy", "Dog"};
        int desiredSongIndex = 4;
        int startingIndex = 6;
        int expected = 2;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }

    @Test
    public void test7() {
        // given
        String[] playlist = {"The", "Quick", "Brown", "Fox", "Jumps", "Over", "The", "Lazy", "Dog"};
        int desiredSongIndex = 4;
        int startingIndex = 2;
        int expected = 2;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }

    @Test
    public void test8() {
        // given
        String[] playlist = {"The", "Quick", "Brown", "Fox", "Jumps", "Over", "The", "Lazy", "Dog"};
        int desiredSongIndex = 1;
        int startingIndex = 3;
        int expected = 2;

        test(playlist, desiredSongIndex, startingIndex, expected);
    }
}
