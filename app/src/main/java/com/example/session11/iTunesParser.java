package com.example.session11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class iTunesParser {

    public ArrayList<Song> ParseJsonToSongs(JSONObject source){
        ArrayList<Song> song = new ArrayList<>();

        try{
            JSONArray jArrSongs = source.getJSONArray("results");
            for(int i  = 0; i< jArrSongs.length(); i++){
                Song songs = new Song();
                songs.title = ((JSONObject)jArrSongs.get(i)).getString("trackName");
                songs.artist = ((JSONObject)jArrSongs.get(i)).getString("artistName");
                songs.artWorks = ((JSONObject)jArrSongs.get(i)).getString("artworkUrl100");
                song.add(songs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return song;
    }
}
