package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void saveStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);
        logger.info("Student saved successfully, Student Details=" + student);
    }

    @Override
    public Student getStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));
        logger.info("Student loaded successfully, Student details=" + student);
        return student;
    }

    @Override
    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student").list();
        for(Student student : studentList){
            logger.info("Student List::" + student);
        }
        return studentList;
    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
        logger.info("Student updated successfully, Student Details="+student);
    }

    @Override
    public Student getStudentByUserId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student where user.id=:c_id").setParameter("c_id", id).list();
        for(Student student : studentList){
            logger.info("Module List::" + student);
        }
        if (studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));
        if(null != student){
            session.delete(student);
        }
        logger.info("Student deleted successfully, student details=" + student);
    }
}
