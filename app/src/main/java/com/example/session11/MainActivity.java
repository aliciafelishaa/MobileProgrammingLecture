package com.example.session11;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvArtist;
    ImageView ivArtwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvArtist = findViewById(R.id.tvArtist);
        ivArtwork = findViewById(R.id.ivArtwork);

        DemoTask task1 = new DemoTask();
        task1.execute();
    }

    private String readStream(InputStream is){
        try{
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int i = is.read();

            while(i!=-1){
                buffer.write(i);
                i = is.read();
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private class  DemoTask extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            try{
                URL url = new URL("https://itunes.apple.com/search?term=beyonce&entity=musicVideo");
                HttpURLConnection urlConn = ((HttpURLConnection) url.openConnection());
                InputStream in = new BufferedInputStream(urlConn.getInputStream());
                result = readStream(in);
                urlConn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            Log.v("response", s);

            iTunesParser myItunesParser = new iTunesParser();
            ArrayList<Song> songs = new ArrayList<>();
            try{
                songs = myItunesParser.ParseJsonToSongs(new JSONObject(s));
            }catch (Exception e) {
                e.printStackTrace();
            }

            String title10 = songs.get(10).title;
            String artist10 = songs.get(10).artist;
            String artwork10 = songs.get(10).artWorks;

            tvTitle.setText(title10);
            tvArtist.setText(artist10);
            Picasso.get()
                    .load(artwork10)
                    .into(ivArtwork);
        }
    }
}