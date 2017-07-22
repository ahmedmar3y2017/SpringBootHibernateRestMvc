package springboothibernate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboothibernate.Entities.Topics;

import java.util.List;

/**
 * Created by ahmed on 7/22/2017.
 */
@Service
public class TopicServiceImpl {
    @Autowired
    public springboothibernate.Dao.topicDao topicDao;

    public void Insert(Topics topics) {
        topicDao.Insert(topics);


    }

    public List<Topics> GetAll() {

        return topicDao.GetAll();

    }

    public Topics GetSpecific(String id) {

        return topicDao.GetSpecific(id);
    }

    public void Update(String id, Topics topics) {
        topicDao.Update(topics);

    }

    public void deleteTopic(String id) {
        topicDao.deleteTopic(id);

    }
}
