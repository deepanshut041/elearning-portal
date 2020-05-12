package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.EnrollmentDao;
import io.github.deepanshut041.sawdhyay.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("enrollmentService")
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Override
    @Transactional
    public void addEnrollment(Enrollment enrollment) {
        this.enrollmentDao.saveEnrollment(enrollment);
    }

    @Override
    @Transactional
    public void updateEnrollment(Enrollment enrollment) {
        this.enrollmentDao.updateEnrollment(enrollment);
    }

    @Override
    @Transactional
    public void deleteEnrollmentById(int id) {
        this.enrollmentDao.deleteEnrollment(id);
    }

    @Override
    @Transactional
    public List<Enrollment> findEnrollmentsByStudent(int id) {
        return this.enrollmentDao.getEnrollmentsByStudent(id);
//        return null;
    }

    @Override
    @Transactional
    public List<Enrollment> findAllEnrollments() {
        return this.enrollmentDao.listEnrollments();
    }

    @Override
    @Transactional
    public Enrollment getEnrollmentById(int id) {
        return this.enrollmentDao.getEnrollment(id);
    }

    @Override
    @Transactional
    public Enrollment getEnrollmentsByStudentAndCourse(int student_id, int course_id) {
        return this.enrollmentDao.getEnrollmentsByStudentAndCourse(student_id, course_id);
    }
}
