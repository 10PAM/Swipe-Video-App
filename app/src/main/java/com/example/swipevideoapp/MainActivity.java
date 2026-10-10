/**
 * Programmers {
 *     Mario Aguilera Piceno
 * }
 * File: MainActivity.java
 * About: Manages the internal linking of files. Implemeentation base
 * on Professor Dr. Zhu's lectures for lab 2.
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
 * The entry point of the app's logic.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * App initialization point.
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

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();

        // Video 1
        VideoItem v_cube = new VideoItem();
        v_cube.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/spinning_cube.mp4";
        v_cube.videoTitle = "Celebration";
        v_cube.videoDescription = "Celebration who you are in your deepest heart";
        v_cube.videoID = "198324";
        videoItemsList.add(v_cube);

        // Video 2
        VideoItem v_cube2 = new VideoItem();
        v_cube2.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/spinning_cube.mp4";
        v_cube2.videoTitle = "Celebration";
        v_cube2.videoDescription = "Celebration who you are in your deepest heart";
        v_cube2.videoID = "198324";
        videoItemsList.add(v_cube2);

        // Video 3
        VideoItem v_cube3 = new VideoItem();
        v_cube3.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/spinning_cube.mp4";
        v_cube3.videoTitle = "Celebration";
        v_cube3.videoDescription = "Celebration who you are in your deepest heart";
        v_cube3.videoID = "198324";
        videoItemsList.add(v_cube3);

        // Video 4
        VideoItem v_cube4 = new VideoItem();
        v_cube4.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/spinning_cube.mp4";
        v_cube4.videoTitle = "Celebration";
        v_cube4.videoDescription = "Celebration who you are in your deepest heart";
        v_cube4.videoID = "198324";
        videoItemsList.add(v_cube4);

        // Video 5
        VideoItem v_cube5 = new VideoItem();
        v_cube5.videoURL = "https://github.com/10PAM/Swipe-Video-App/raw/refs/heads/master/videos/spinning_cube.mp4";
        v_cube5.videoTitle = "Celebration";
        v_cube5.videoDescription = "Celebration who you are in your deepest heart";
        v_cube5.videoID = "198324";
        videoItemsList.add(v_cube5);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}