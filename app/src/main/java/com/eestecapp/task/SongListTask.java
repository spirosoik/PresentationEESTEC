package com.eestecapp.task;

import android.os.AsyncTask;
import com.eestecapp.Constants;
import com.eestecapp.Utils;
import com.eestecapp.model.SongEntity;
import com.eestecapp.ui.songslist.SongsFragment;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Spiros I. Oikonomakis on 07/12/15.
 */
public class SongListTask extends AsyncTask<String, Void, String> {

  private final SongsFragment fragment;

  public SongListTask(SongsFragment songsFragment) {
    this.fragment = songsFragment;
  }

  @Override protected String doInBackground(String... params) {

    String responseString = null;
    HttpURLConnection urlConnection = null;
    URL url;
    try {

      StringBuilder sb = new StringBuilder(Constants.API_URL).append("&term")
          .append("=")
          .append(URLEncoder.encode(params[0], "UTF-8"));

      url = new URL(sb.toString());
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.setRequestMethod("GET");
      InputStream in = new BufferedInputStream(urlConnection.getInputStream());
      responseString = Utils.readIt(in, 500);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
    }
    return responseString;
  }

  @Override protected void onPostExecute(String json) {
    super.onPostExecute(json);
    if (json != null) {
      try {
        JSONObject jsonObject = new JSONObject(json);
        SongEntity[] songEntityList;
        songEntityList = new Gson().fromJson(jsonObject.get("results").toString(), SongEntity[].class);

        fragment.showListSongs(songEntityList);
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
  }
}
