package utils;

import exceptions.BeatlesException;

import java.io.*;

public class SongTools {
    //Also there is a way to read a file using FileInputStream
    public static void writeSongToFile(String filename, String song) {
        try(PrintWriter printWriter = new PrintWriter(filename)){
            printWriter.println(song);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readSongFromFile(String filename) {
        StringBuilder song = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line = bufferedReader.readLine();

            while(line != null) {
                song.append(line);
                song.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        return song.toString();
    }

    public static void findStringInSong(String song, String randomString) throws BeatlesException {
        if (!song.contains(randomString)) {
            throw new BeatlesException(randomString + " not found");
        } else {
            System.out.println(randomString + " found");
        }
    }
}
