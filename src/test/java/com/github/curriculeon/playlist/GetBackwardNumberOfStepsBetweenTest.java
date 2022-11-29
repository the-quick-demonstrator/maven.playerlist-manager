package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/2021.
 */
@SuppressWarnings("all")
public class GetBackwardNumberOfStepsBetweenTest {
    private void test(String[] songNameList, Integer startingIndex, Integer desiredSongIndex, Integer expectedNumberOfSteps) {
        // given
        Playlist playlist = new Playlist(songNameList);
        String desiredSong = songNameList[desiredSongIndex];

        // when
        Integer actualNumberOfSteps = playlist.getBackwardNumberOfStepsBetween(startingIndex, desiredSong);

        // then
        Assert.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

    @Test
    public void test1() {
        // given
        String[] songNameList = {
                "wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"
        };
        Integer startingIndex = 1;
        Integer desiredSongIndex = songNameList.length-1;
        Integer expectedNumberOfSteps = 2;

        // when
        test(songNameList, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }

    @Test
    public void test2() {
        // given
        String[] songNameList = new String[]{"dancinginthedark", "rio", "liveoak", "liveoak"};
        Integer startingIndex = 1;
        Integer desiredSongIndex = songNameList.length-1;
        Integer expectedNumberOfSteps = 2;

        // when
        test(songNameList, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test3() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 0;
        Integer expectedNumberOfSteps = 2;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test4() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 1;
        Integer expectedNumberOfSteps = 3;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test5() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 2;
        Integer expectedNumberOfSteps = 4;
        Integer desiredSongIndex = 5;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }


    @Test
    public void test6() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 5;
        Integer expectedNumberOfSteps = 1;
        Integer desiredSongIndex = 4;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }

    @Test
    public void test7() {
        String[] songNameArray = {"the", "quick", "brown", "fox", "jumps", "over", "the"};
        Integer startingIndex = 5;
        Integer expectedNumberOfSteps = 4;
        Integer desiredSongIndex = 1;

        // when
        test(songNameArray, startingIndex, desiredSongIndex, expectedNumberOfSteps);
    }
}
