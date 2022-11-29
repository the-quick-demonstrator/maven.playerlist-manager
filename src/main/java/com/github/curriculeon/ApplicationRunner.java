package com.github.curriculeon;

import com.github.git_leon.console.SystemConsole;

import java.util.StringJoiner;

public class ApplicationRunner implements Runnable {
    public void run() {
        PlaylistManager playlistManager = new PlaylistManager();


        String userInput;
        do {


            String playlistManagerMenuInput;
            do {
                playlistManagerMenuInput = getPlaylistManagerInput();
                if ("add".equalsIgnoreCase(playlistManagerMenuInput)) {
                    String songToAdd = SystemConsole.getStringInput("Enter song to add to playlist:");
                    playlistManager.addSong(songToAdd);
                } else if ("remove".equalsIgnoreCase(playlistManagerMenuInput)) {
                    String songToRemove = SystemConsole.getStringInput("Enter song to remove to playlist:");
                    playlistManager.removeSong(songToRemove);
                } else if ("print-all".equalsIgnoreCase(playlistManagerMenuInput)) {
                    playlistManager.printAll();
                } else if ("playlist-menu".equalsIgnoreCase(playlistManagerMenuInput)) {


                    String playlistMenuInput;
                    do {
                        playlistMenuInput = getPlaylistMenuInput();
                        if ("next-song".equalsIgnoreCase(playlistMenuInput)) {
                            playlistManager.getPlaylist().goToNextSong();
                        } else if ("previous-song".equalsIgnoreCase(playlistMenuInput)) {
                            playlistManager.getPlaylist().goToPreviousSong();
                        } else if ("current-song".equalsIgnoreCase(playlistMenuInput)) {
                            SystemConsole.println(playlistManager.getPlaylist().getCurrentSelection());
                        } else if ("get-forward-steps".equalsIgnoreCase(playlistMenuInput)) {
                            Integer currentIndex = SystemConsole.getIntegerInput("Enter the starting index");
                            String desiredSong = SystemConsole.getStringInput("Enter desired song name");
                            SystemConsole.println(playlistManager
                                    .getPlaylist()
                                    .getForwardNumberOfStepsBetween(currentIndex, desiredSong)
                                    .toString());
                        } else if ("get-backward-steps".equalsIgnoreCase(playlistMenuInput)) {
                            Integer currentIndex = SystemConsole.getIntegerInput("Enter the starting index");
                            String desiredSong = SystemConsole.getStringInput("Enter desired song name");
                            SystemConsole.println(playlistManager
                                    .getPlaylist()
                                    .getBackwardNumberOfStepsBetween(currentIndex, desiredSong)
                                    .toString());
                        } else if ("get-minimum-steps".equalsIgnoreCase(playlistMenuInput)) {
                            Integer currentIndex = SystemConsole.getIntegerInput("Enter the starting index");
                            String desiredSong = SystemConsole.getStringInput("Enter desired song name");
                            SystemConsole.println(playlistManager
                                    .getPlaylist()
                                    .getMinimumNumberOfStepsBetween(currentIndex, desiredSong)
                                    .toString());
                        }
                    } while (!"quit".equalsIgnoreCase(playlistMenuInput));
                }
            } while (!"quit".equalsIgnoreCase(playlistManagerMenuInput));
            userInput = getApplicationRunnerInput();
        } while (!"quit".equalsIgnoreCase(userInput));
    }

    private String getPlaylistMenuInput() {
        return getMenuInput(
                "Playlist",
                "quit", "previous-song", "current-song", "get-forward-steps", "get-backward-steps", "get-minimum-steps");
    }

    private String getApplicationRunnerInput() {
        return getMenuInput(
                "ApplicationRunner",
                "quit", "continue");
    }

    private String getPlaylistManagerInput() {
        return getMenuInput(
                "PlaylistManager",
                "quit", "add", "remove", "print-all", "playlist-menu");
    }

    private String getMenuInput(String menuName, String... optionArray) {
        StringJoiner options = new StringJoiner(", ");
        for (String option : optionArray) {
            options.add("[".concat(option).concat("]"));
        }
        return SystemConsole.getStringInput(new StringJoiner("\n")
                .add("Welcome to the ".concat(menuName).concat(" Menu!"))
                .add("From here, you can select any of the following:")
                .add("\t".concat(options.toString()))
                .toString()
                .replaceAll("$ ", ""));
    }
}
