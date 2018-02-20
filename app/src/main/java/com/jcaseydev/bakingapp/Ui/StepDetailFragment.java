package com.jcaseydev.bakingapp.Ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;


/**
 * Created by jcasey on 2/13/18.
 */

public class StepDetailFragment extends Fragment {
    Step stepDetails;
    SimpleExoPlayer player;
    SimpleExoPlayerView playerView;
    Uri videoURL;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            stepDetails = getArguments().getParcelable("STEP/DETAILS");
        }

        player = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step_detail, container, false);

        if (!stepDetails.getVideoUrl().isEmpty()){
        videoURL = Uri.parse(stepDetails.getVideoUrl());

        playerView = v.findViewById(R.id.player_view);
        playerView.setPlayer(player);


            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(v.getContext(), Util.getUserAgent(getContext(), "Baking APP"), bandwidthMeter);
            MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(videoURL);

            player.prepare(mediaSource);
            player.setPlayWhenReady(true);
        }else {
            Log.d("ERROR", "VIDEO URL IS EMPTY");
        }

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}
