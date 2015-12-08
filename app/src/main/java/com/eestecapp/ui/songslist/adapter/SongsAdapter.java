package com.eestecapp.ui.songslist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.eestecapp.R;
import com.eestecapp.model.SongEntity;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

/**
 * Created by Spiros I. Oikonomakis on 08/12/15.
 */
public class SongsAdapter extends BaseAdapter {

  private final Context context;
  private SongEntity[] songs;
  private final LayoutInflater layoutInflater;

  public SongsAdapter(Context context, SongEntity[] songs) {
    this.context = context;
    this.songs = songs;
    this.layoutInflater = LayoutInflater.from(context);

  }

  @Override public int getCount() {
    return this.songs != null && this.songs.length > 0 ? this.songs.length : 0;
  }

  @Override public Object getItem(int position) {
    return this.songs[position];
  }

  @Override public long getItemId(int position) {
    return this.songs[position].hashCode();
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    View rowView = this.layoutInflater.inflate(R.layout.row_song, parent, false);

    ImageView ivIcon = (ImageView) rowView.findViewById(R.id.avatar);
    TextView tvTitle = (TextView) rowView.findViewById(R.id.trackName);
    TextView tvArtist = (TextView) rowView.findViewById(R.id.trackArtistName);

    SongEntity songEntity = this.songs[position];
    if (songEntity != null) {
      Picasso.with(context).load(songEntity.getImage()).into(ivIcon);
      tvTitle.setText(songEntity.getTrackName());
      tvArtist.setText(songEntity.getArtistName());
    }

    return rowView;
  }

  public void setSongsList(SongEntity[] songs) {
    this.songs = songs;
    this.notifyDataSetChanged();
  }

}
