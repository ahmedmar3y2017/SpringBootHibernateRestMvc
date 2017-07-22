package springboothibernate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboothibernate.Dao.courseDaoImpl;
import springboothibernate.Entities.Course;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@Service
public class CourseServiceImpl {

    @Autowired
    courseDaoImpl courseDao;

    public void insert(Course course) {
        courseDao.insert(course);

    }


    public List<Course> getAll(String id) {


        return courseDao.getAll(id);


    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public void Delete(String courseId) {
        courseDao.Delete(courseId);

    }

    public Course getSpecific(String id) {

        return courseDao.getSpecific(id);
    }

}
