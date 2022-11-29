package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

public class GetCurrentSongUponConstruction {
    private void test(String[] songNameArray, Integer initialIndex) {
        // given
        Playlist playlist = new Playlist(initialIndex, songNameArray);
        String expected = songNameArray[initialIndex];

        // when
        String actual = playlist.getCurrentSelection();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // given
        test(new String[]{
                "wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"
        }, 0);
    }


    @Test
    public void test2() {
        // given
        test(new String[]{
                "the quick",
                "brown fox",
                "jumps over",
                "the lazy dog"
        }, 0);

    }

    @Test
    public void test3() {
        // given
        test(new String[]{
                "the quick",
                "brown fox",
                "jumps over",
                "the lazy dog"
        }, 3);
    }
}
