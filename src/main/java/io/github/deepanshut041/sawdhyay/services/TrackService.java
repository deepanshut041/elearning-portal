package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Track;

import java.util.List;

public interface TrackService {

    void addTrack(Track track);

    void updateTrack(Track track);

    void deleteTrackById(int id);

    List<Track> findAllTracks();

    Track getTrackById(int id);
    
}
