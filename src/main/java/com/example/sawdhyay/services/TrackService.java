package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Track;

import java.util.List;

public interface TrackService {

    void addTrack(Track track);

    void updateTrack(Track track);

    void deleteTrackById(int id);

    List<Track> findAllTracks();

    Track getTrackById(int id);
    
}
