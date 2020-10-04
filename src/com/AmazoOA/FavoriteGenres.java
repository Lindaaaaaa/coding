package com.AmazoOA;

import java.util.*;

/**
 * Created by Lindaliu on 2020-09-30.
 */
//https://leetcode.com/discuss/interview-question/373006/Amazon-or-OA-2019-or-Favorite-Genres
public class FavoriteGenres {


    /*
    Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

    Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

    The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
            Input:
            userSongs = {
            "David": ["song1", "song2", "song3", "song4", "song8"],
            "Emma":  ["song5", "song6", "song7"]
            },
            songGenres = {
            "Rock":    ["song1", "song3"],
            "Dubstep": ["song7"],
            "Techno":  ["song2", "song4"],
            "Pop":     ["song5", "song6"],
            "Jazz":    ["song8", "song9"]
            }

            Output: {
            "David": ["Rock", "Techno"],
            "Emma":  ["Pop"]
            }

            Explanation:
            David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
            Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.*/
    public class Main {
        public  void  main(String[] args) {
            Map<String, List<String>> userSongs = new HashMap<>();
            List<String> u1songs = Arrays.asList("song1","song2","song3","song4","song8");
            List<String> u2songs = Arrays.asList("song5","song6","song7");
            userSongs.put("David", u1songs);
            userSongs.put("Emma", u2songs);

            Map<String, List<String>> songGenres = new HashMap<>();
            List<String> rockSong = Arrays.asList("song1", "song3");
            List<String> Dubstep = Arrays.asList("song7");
            List<String> Techno = Arrays.asList("song2", "song4");
            List<String> Pop = Arrays.asList("song5", "song6");
            List<String> Jazz = Arrays.asList("song8", "song9");
//        songGenres.put("rock", rockSong);
//        songGenres.put("Dubstep", Dubstep);
//        songGenres.put("Techno", Techno);
//        songGenres.put("Pop", Pop);
//        songGenres.put("Jazz", Jazz);

            Map<String, List<String>> map = solve(userSongs, songGenres);
            map.forEach((key, value) -> System.out.println(key + ":" + value));

        }

        public  Map<String, List<String>> solve(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
            Map<String, List<String>> res = new HashMap<>();
            Map<String, String> songstogenre = new HashMap<>();
            for (String key :songGenres.keySet()){
                List<String> songs = songGenres.get(key);
                for (String song: songs) {
                    songstogenre.put(song, key);
                }
            }

            for (String key: userSongs.keySet()){
                List<String> songs = userSongs.get(key);
                List<String> resGenres = new LinkedList<>();
                if (songs!= null) {
                    Map<String, Integer> genreCount = new HashMap<>();
                    // <genre, count>
                    for (String song : songs) {
                        if (songstogenre.containsKey(song)) {
                            String genre = songstogenre.get(song);
                            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
                        }
                    }
                    if (genreCount.size()>0) {
                        int maxValueInMap = (Collections.max(genreCount.values()));
                        for (String genre : genreCount.keySet()) {
                            if (genreCount.get(genre) == maxValueInMap) {
                                resGenres.add(genre);
                            }
                        }
                    }
                }

                res.put(key, resGenres);
            }
            return res;
        }
    }

}
