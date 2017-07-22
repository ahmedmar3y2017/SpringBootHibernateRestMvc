package springboothibernate.Restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboothibernate.Entities.Course;
import springboothibernate.Entities.Topics;
import springboothibernate.Service.CourseServiceImpl;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@RestController
@RequestMapping("/rest")
public class CourseRest {
    @Autowired
    CourseServiceImpl courseService;

    @RequestMapping(value = "/topics/{topicId}/Course", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNew(@RequestBody Course Course, @PathVariable("topicId") String topicId) {
        Course.setTopicsByTopicId(new Topics(topicId, "", ""));
        courseService.insert(Course);
    }

    @RequestMapping(value = "/topics/{topicId}/Course/{courseId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpdateCourse(@RequestBody Course Course, @PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
        Course.setTopicsByTopicId(new Topics(topicId, "", ""));
        courseService.update(Course);
    }


    @RequestMapping(value = "/topics/{id}/Course", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> GetAllByTopicId(@PathVariable("id") String id) {
        return courseService.getAll(id);
    }

    @RequestMapping(value = "/topics/{topicId}/Course/{CourseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course Getspecific(@PathVariable("CourseId") String CourseId) {

        return courseService.getSpecific(CourseId);

    }

    @RequestMapping(value = "/topics/{topicId}/Course/{CourseId}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable("CourseId") String CourseId) {
        courseService.Delete(CourseId);
    }

}
