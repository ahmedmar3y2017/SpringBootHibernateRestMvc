package springboothibernate.Restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboothibernate.Entities.Topics;
import springboothibernate.Service.TopicServiceImpl;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@RestController
@RequestMapping("/rest")
public class TopicRest {
    @Autowired
    TopicServiceImpl topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@RequestBody Topics topics) {
        topicService.Insert(topics);

    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Topics> GetAll() {
        return topicService.GetAll();

    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Topics Getspecific(@PathVariable("id") String id) {


        return topicService.GetSpecific(id);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpdateTopic(@RequestBody Topics topics, @PathVariable("id") String id) {

        topicService.Update(id, topics);

    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void DeleteTopic(@PathVariable("id") String id) {

        topicService.deleteTopic(id);

    }


}
