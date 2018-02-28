package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Track;

import java.util.List;

public interface TrackDao {

    void saveTrack(Track track);
    Track getTrack(int id);
    List<Track> listTracks();
    void updateTrack(Track track);
    void deleteTrack(int id);

}
