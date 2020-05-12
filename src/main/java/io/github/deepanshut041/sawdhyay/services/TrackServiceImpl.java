package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.TrackDao;
import io.github.deepanshut041.sawdhyay.models.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("trackService")
public class TrackServiceImpl implements TrackService{

    @Autowired
    private TrackDao trackDao;

    @Override
    @Transactional
    public void addTrack(Track track) {
        this.trackDao.saveTrack(track);
    }

    @Override
    @Transactional
    public void updateTrack(Track track) {
        this.trackDao.updateTrack(track);
    }

    @Override
    @Transactional
    public void deleteTrackById(int id) {
        this.trackDao.deleteTrack(id);
    }

    @Override
    @Transactional
    public List<Track> findAllTracks() {
        return this.trackDao.listTracks();
    }

    @Override
    @Transactional
    public Track getTrackById(int id) {
        return this.trackDao.getTrack(id);
    }
}
