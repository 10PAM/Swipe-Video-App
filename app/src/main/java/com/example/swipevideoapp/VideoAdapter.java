package com.example.swipevideoapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Handles video screens.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    final private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    /**
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return Returns something
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false));
    }

    /**
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     *
     * @return Returns
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     *
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder{

        /**
         * Video UI Fields
         */
        TextView textVideoTitle, textVideoDescription, textVideoID;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         * Static class that
         * @param itemView Compare
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            textVideoID = itemView.findViewById(R.id.textVideoID);
            textVideoDescription = itemView.findViewById(R.id.textVideoDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        /**
         * Handles instantiation and updating of all video data.
         * @param videoItem Compares
         */
        void setVideoData(VideoItem videoItem) {
            textVideoTitle.setText(videoItem.videoTitle);
            textVideoID.setText(videoItem.videoID);
            textVideoDescription.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);
            progressBar = itemView.findViewById(R.id.videoProgressBar);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                /**
                 *
                 * @param mp the MediaPlayer that is ready for playback
                 */
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    // Compresses video's scale by its ratio for optimal viewing
                    float videoRatio = (float)mp.getVideoWidth() / (float)mp.getVideoHeight();
                    float screenRatio = (float)videoView.getWidth() / (float)videoView.getHeight();
                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f) {

                    } else {

                    }
                    videoView.setScaleX(scale);
                    videoView.setScaleY(1f);
                    videoView.setX(1f);
                    videoView.setY(1f);
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                /**
                 *
                 *
                 * @param mp the MediaPlayer that reached the end of the file
                 */
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
