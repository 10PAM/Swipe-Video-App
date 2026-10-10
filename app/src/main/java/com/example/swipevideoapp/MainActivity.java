/**
 * Programmers {
 *     Mario Aguilera Piceno
 * }
 * File: MainActivity.java
 * About: Manages the internal linking of files and core logic of tbe app.
 * Implementation is based on Professor Dr. Shangyue Zhu's lectures for lab 2.
 * Created: 10/10/2026
 * Modified: 10/10/2026
 */

package com.example.swipevideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

/**
 * The entry point of the app's implemented logic.
 */
public class MainActivity extends AppCompatActivity {


    /**
     * The container for the videos.
     */
    final private List<VideoItem> videoItemsList = new ArrayList<>();
    ViewPager2 videoViewPager = null;

    /**
     * App initialization point on start.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        videoViewPager = findViewById(R.id.videosViewPager);

        addVideo("Spinning 3D Cube", "Video of progress for my game engine that I am working on as a hobby during my free time. Learning how to use a rendering library and how to apply it to my engine.", "198324");
        addVideo("Lockscreen", "Vibe coding.", "168324");
        addVideo("PC Part Boxes", "Storing my valuable boxes!", "138322");
        addVideo("Programmig Books", "My library...", "128327");
        addVideo("Swipe App", "An overview of this app.", "108321");

        // Initializes video pager with created videos
        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }

    /**
     * Adds a video modularly.
     */
    void addVideo(String title, String description, String id) {
        VideoItem video = new VideoItem();
        video.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/"+id+".mp4";
        video.videoTitle = title;
        video.videoDescription = description;
        video.videoID = "ID: "+id;
        videoItemsList.add(video);
    }
}