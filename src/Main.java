import exceptions.BeatlesException;
import utils.LengthComparator;
import utils.SongTools;
import utils.StringTools;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BeatlesException {

        // PART 1
        String song = "In the town where I was born\n" +
                "Lived a man who sailed to sea\n" +
                "And he told us of his life\n" +
                "In the land of submarines\n" +
                "So we sailed on to the sun\n" +
                "'Til we found a sea of green\n" +
                "And we lived beneath the waves\n" +
                "In our yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "And our friends are all aboard\n" +
                "Many more of them live next door\n" +
                "And the band begins to play\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "Full steam ahead, Mister Boatswain, full steam ahead\n" +
                "Full steam ahead it is, Sergeant\n" +
                "(Cut the cable, drop the cable)\n" +
                "Aye-aye, sir, aye-aye\n" +
                "Captain, captain\n" +
                "As we live a life of ease (a life of ease)\n" +
                "Every one of us (every one of us)\n" +
                "Has all we need (has all we need)\n" +
                "Sky of blue (sky of blue)\n" +
                "And sea of green (sea of green)\n" +
                "In our yellow (in our yellow)\n" +
                "Submarine (submarine, aha)\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine";

        String formattedSong = StringTools.removeChars(song, ",", "\n").toLowerCase();
        //System.out.println(formattedSong);
        String[] array = formattedSong.split("\\s+");
//        for (var s : array) {
//            System.out.println(s);
//        }

        String word = "yellow";
        System.out.println("Number of occurences of word - " + word + " = " + StringTools.countOccurences(array, word));

        // PART 2
        //count occurences of specified word
        List<String> list = new ArrayList<>(Arrays.asList(array));
        int occurences = Collections.frequency(list, "yellow");
        System.out.println("Number of occurences using Collections of word - " + word + " = " + occurences);

        //remove duplicates
        List<String> listWithoutDuplicates = StringTools.removeDuplicatesFromList(list);
        System.out.println(listWithoutDuplicates);

        //sort by length
        listWithoutDuplicates.sort(new LengthComparator());
        System.out.println(listWithoutDuplicates);

        // PART 3
        //remove word yellow and submarine from list
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        list.removeIf(w -> w.equals("yellow") || w.equals("submarine"));
        System.out.println(list2);


        // PART 4
        SongTools.writeSongToFile("song.txt", song);
        String songFromFile = SongTools.readSongFromFile("song.txt");
        System.out.println(songFromFile);

        SongTools.findStringInSong(songFromFile, "Show must go on!");
    }
}