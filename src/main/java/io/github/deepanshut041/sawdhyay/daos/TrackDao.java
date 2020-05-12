package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Track;

import java.util.List;

public interface TrackDao {

    void saveTrack(Track track);
    Track getTrack(int id);
    List<Track> listTracks();
    void updateTrack(Track track);
    void deleteTrack(int id);

}
