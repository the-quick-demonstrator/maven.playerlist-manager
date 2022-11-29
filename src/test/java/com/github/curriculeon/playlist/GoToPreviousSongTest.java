package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

public class GoToPreviousSongTest {
    private void test(int initialIndex, String[] songNameArray, String expected) {
        // given
        Playlist playlist = new Playlist(initialIndex, songNameArray);
        String initialSongSelection = playlist.getCurrentSelection();

        // when
        playlist.goToPreviousSong();
        String actual = playlist.getCurrentSelection();

        // then
        Assert.assertNotEquals(initialSongSelection, actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test1() {
        // given
        test(0, new String[]{
                "wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"
        }, "cecelia");
    }


    @Test
    public void test2() {
        // given
        test(1, new String[]{
                "wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"
        }, "wheniseeyouagain");
    }


    @Test
    public void test3() {
        // given
        test(3, new String[]{
                "wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"
        }, "nothingelsematters");
    }
}
