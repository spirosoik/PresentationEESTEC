package com.eestecapp.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SongEntity implements Serializable {

  private String trackName;

  private String artistName;

  private String collectionName;

  @SerializedName("artworkUrl30")
  private String image;

  @SerializedName("artworkUrl60")
  private String imageMedium;

  @SerializedName("artworkUrl100")
  private String imageBig;

  private Double trackPrice;

  private String radioStationUrl;

  private String artistViewUrl;

  @SerializedName("primaryGenreName")
  private String genre;

  public SongEntity() {
  }

  public String getTrackName() {
    return trackName;
  }

  public String getArtistName() {
    return artistName;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImageMedium() {
    return imageMedium;
  }

  public void setImageMedium(String imageMedium) {
    this.imageMedium = imageMedium;
  }

  public String getImageBig() {
    return imageBig;
  }

  public void setImageBig(String imageBig) {
    this.imageBig = imageBig;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public Double getTrackPrice() {
    return trackPrice;
  }

  public void setTrackPrice(Double trackPrice) {
    this.trackPrice = trackPrice;
  }

  public String getRadioStationUrl() {
    return radioStationUrl;
  }

  public void setRadioStationUrl(String radioStationUrl) {
    this.radioStationUrl = radioStationUrl;
  }

  public String getArtistViewUrl() {
    return artistViewUrl;
  }

  public void setArtistViewUrl(String artistViewUrl) {
    this.artistViewUrl = artistViewUrl;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}