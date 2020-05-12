package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Track;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("trackDao")
public class TrackDaoImpl implements TrackDao {

    private static final Logger logger = LoggerFactory.getLogger(TrackDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveTrack(Track track) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(track);
        logger.info("Track saved successfully, Track Details=" + track);
    }

    @Override
    public Track getTrack(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Track track = (Track) session.load(Track.class, new Integer(id));
        logger.info("Track loaded successfully, Track details=" + track);
        return track;
    }

    @Override
    public List<Track> listTracks() {
        Session session = sessionFactory.getCurrentSession();
        List<Track> trackList = session.createQuery("from Track").list();
        for(Track track : trackList){
            logger.info("Track List::" + track);
        }
        return trackList;
    }

    @Override
    public void updateTrack(Track track) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(track);
        logger.info("Track updated successfully, Track Details="+track);
    }

    @Override
    public void deleteTrack(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Track track = (Track) session.load(Track.class, new Integer(id));
        if(null != track){
            session.delete(track);
        }
        logger.info("Track deleted successfully, track details=" + track);
    }
}
