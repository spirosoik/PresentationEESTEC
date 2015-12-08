package com.eestecapp.ui.songshow;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.eestecapp.R;
import com.eestecapp.model.SongEntity;
import com.squareup.picasso.Picasso;

/**
 * Created by Spiros I. Oikonomakis on 08/12/15.
 */
public class SongShowFragment extends Fragment implements View.OnClickListener {

  // CONFIG
  private final static String ARG_SONG = "com.eestecapp.ui.songshow.fragment.SONG";
  private SongEntity songEntity;

  // UI
  private ImageView ivAvatar;
  private TextView txtTrackName;
  private TextView txtTrackArtistName;
  private TextView tvGenreName;
  private TextView tvListenLink;
  private TextView tvLinkArtist;
  private TextView tvTrackPrice;

  public static SongShowFragment newInstance(SongEntity songEntity) {
    Bundle bundle = new Bundle();
    bundle.putSerializable(ARG_SONG, songEntity);
    SongShowFragment songShowFragment = new SongShowFragment();
    songShowFragment.setArguments(bundle);
    return songShowFragment;
  }

  public SongShowFragment() {
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle arguments = getArguments();
    if (arguments.containsKey(ARG_SONG)) {
      this.songEntity = (SongEntity) arguments.get(ARG_SONG);
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_song_show, container, false);

    ivAvatar = (ImageView) fragmentView.findViewById(R.id.avatar);
    txtTrackName = (TextView) fragmentView.findViewById(R.id.trackName);
    txtTrackArtistName = (TextView) fragmentView.findViewById(R.id.trackArtistName);
    tvGenreName  = (TextView) fragmentView.findViewById(R.id.tvGenreName);
    tvTrackPrice  = (TextView) fragmentView.findViewById(R.id.tvTrackPrice);
    tvGenreName  = (TextView) fragmentView.findViewById(R.id.tvGenreName);
    tvListenLink  = (TextView) fragmentView.findViewById(R.id.tvListenLink);
    tvLinkArtist  = (TextView) fragmentView.findViewById(R.id.tvLinkArtist);

    tvListenLink.setOnClickListener(this);
    tvLinkArtist.setOnClickListener(this);

    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Picasso.with(getContext()).load(this.songEntity.getImageBig().replace("100x100", "500x500")).into(ivAvatar);
    txtTrackName.setText(this.songEntity.getTrackName());
    txtTrackArtistName.setText(this.songEntity.getArtistName());
    tvGenreName.setText(this.songEntity.getGenre());
    tvTrackPrice.setText(String.valueOf(this.songEntity.getTrackPrice()));
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.tvListenLink:
        showLinkInWeb(this.songEntity.getRadioStationUrl());
        break;
      case R.id.tvLinkArtist:
        showLinkInWeb(this.songEntity.getArtistViewUrl());
        break;
    }
  }

  private void showLinkInWeb(String  url) {
    new CustomTabsIntent.Builder().setShowTitle(true)
        .enableUrlBarHiding()
        .setToolbarColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary))
        .build()
        .launchUrl(getActivity(), Uri.parse(url));
  }
}
