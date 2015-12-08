package com.eestecapp.ui.songslist;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.eestecapp.R;
import com.eestecapp.model.SongEntity;
import com.eestecapp.ui.songshow.SongShowActivity;

public class SongsActivity extends AppCompatActivity implements SongsFragment.SongsListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Add Fragment to Activity
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.fragmentView, SongsFragment.newInstance());
    ft.commit();
  }

  @Override public void onSongSelected(SongEntity songEntity) {
    Intent intent = new Intent(SongsActivity.this, SongShowActivity.class);
    intent.putExtra(SongShowActivity.EXTRA_PARAM_SONG, songEntity);
    startActivity(intent);
  }
}
