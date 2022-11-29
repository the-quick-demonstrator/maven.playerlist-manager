package com.github.curriculeon;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    private int currentIndex;
    private final String[] songNameArray;

    public Playlist(String[] songNameArray) {
        this(0, songNameArray);
    }

    public Playlist(int currentIndex, String[] songNameArray) {
        this.currentIndex = currentIndex;
        this.songNameArray = songNameArray;
    }

    public String[] getSongNameArray() {
        return songNameArray;
    }

    public String getCurrentSelection() {
        return songNameArray[currentIndex];
    }

    public void goToPreviousSong() {
        int previousSongIndex = currentIndex - 1;
        int lastSongIndex = songNameArray.length - 1;
        boolean isPreviousSongAfterCurrentSong = previousSongIndex < 0;
        if (isPreviousSongAfterCurrentSong) {
            currentIndex = lastSongIndex;
        } else {
            currentIndex--;
        }
    }

    public void goToNextSong() {
        int nextSongIndex = currentIndex + 1;
        int lastSongIndex = songNameArray.length - 1;
        boolean isNextSongBeforeCurrentSong = nextSongIndex > lastSongIndex;
        if (isNextSongBeforeCurrentSong) {
            currentIndex = 0;
        } else {
            currentIndex++;
        }
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        int backwardSteps = getBackwardNumberOfStepsBetween(currentIndex, desiredSong);
        int forwardSteps = getForwardNumberOfStepsBetween(currentIndex, desiredSong);
        boolean lessBackwards = backwardSteps < forwardSteps;
        if (lessBackwards) {
            return backwardSteps;
        }
        return forwardSteps;
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        return null;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        this.currentIndex = currentIndex;
        int stepsBetween = 0;
        while (!getCurrentSelection().equals(desiredSong)) {
            goToNextSong();
            stepsBetween++;
        }
        return stepsBetween;
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        this.currentIndex = currentIndex;
        int stepsBetween = 0;
        while (!getCurrentSelection().equals(desiredSong)) {
            goToPreviousSong();
            stepsBetween++;
        }
        return stepsBetween;
    }
}
