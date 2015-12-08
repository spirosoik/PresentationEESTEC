package com.eestecapp.ui.songslist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.eestecapp.R;
import com.eestecapp.model.SongEntity;
import com.eestecapp.task.SongListTask;
import com.eestecapp.ui.songshow.SongShowActivity;
import com.eestecapp.ui.songslist.adapter.SongsAdapter;

public class SongsFragment extends Fragment implements AdapterView.OnItemClickListener {

  private SongsAdapter songsAdapter;
  private ListView lvSongs;
  private SongsListener songsListener;

  interface SongsListener {
    void onSongSelected(SongEntity songEntity);
  }

  public static SongsFragment newInstance() {
    return new SongsFragment();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof SongsActivity) {
      this.songsListener = (SongsListener) context;
    }
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View fragmentView = inflater.inflate(R.layout.fragment_songs, container, false);

    lvSongs = (ListView) fragmentView.findViewById(R.id.lvSongs);
    lvSongs.setOnItemClickListener(this);
    songsAdapter = new SongsAdapter(getActivity(), new SongEntity[]{});
    this.lvSongs.setAdapter(songsAdapter);
    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    songsAdapter = new SongsAdapter(getActivity(), new SongEntity[]{});
    this.lvSongs.setAdapter(songsAdapter);

    SongListTask songListTask = new SongListTask(this);
    songListTask.execute("dream theater");
  }

  /**
   * Fills the list with data
   * @param songs a list of {@link SongEntity}
   */
  public void showListSongs(SongEntity[] songs) {
    songsAdapter.setSongsList(songs);
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    SongEntity songEntity = (SongEntity) songsAdapter.getItem(position);
    if (songEntity != null) {
      this.songsListener.onSongSelected(songEntity);
    }
  }
}
