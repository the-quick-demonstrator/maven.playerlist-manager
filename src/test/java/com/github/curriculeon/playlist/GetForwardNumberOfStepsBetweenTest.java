package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/2021.
 */
public class GetForwardNumberOfStepsBetweenTest {
    private void test(String[] songNameList, Integer startingIndex, Integer desiredSongIndex, Integer expectedNumberOfSteps) {
        // given
        Playlist playlist = new Playlist(songNameList);
        String desiredSong = songNameList[desiredSongIndex];

        // when
        Integer actualNumberOfSteps = playlist.getForwardNumberOfStepsBetween(startingIndex, desiredSong);

        // then
        Assert.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

    @Test
    public void test1() {
        // given
        String[] songNameArray = {"wheniseeyouagain", "borntorun", "nothingelsematters", "cecelia"};
        Integer startingIndex = 1;
        Integer desiredSongIndex = 3;
        Integer expectedNumberOfSteps = 2;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test2() {
        // given
        String[] songNameArray = {"dancinginthedark", "rio", "liveoak", "liveoak"};
        Integer startingIndex = 0;
        Integer desiredSongIndex = 3;
        Integer expectedNumberOfSteps = 2;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }

    @Test
    public void test3() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 0;
        Integer expectedNumberOfSteps = 5;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test4() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 1;
        Integer expectedNumberOfSteps = 4;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test5() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 2;
        Integer expectedNumberOfSteps = 3;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test6() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 5;
        Integer expectedNumberOfSteps = 6;
        Integer desiredSongIndex = 4;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }

    @Test
    public void test7() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 5;
        Integer expectedNumberOfSteps = 3;
        Integer desiredSongIndex = 1;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }

}
