package springboothibernate.Entities;

import javax.persistence.*;

/**
 * Created by ahmed on 7/22/2017.
 */
@Entity
public class Course {
    private String id;
    private String description;
    private String username;
    private String topicId;
    private Topics topicsByTopicId;

    public Course(String id, String description, String username, String topicId) {
        this.id = id;
        this.description = description;
        this.username = username;
        this.topicId = topicId;
    }

    public Course() {
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "topic_id", insertable = false , updatable = false)
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (username != null ? !username.equals(course.username) : course.username != null) return false;
        if (topicId != null ? !topicId.equals(course.topicId) : course.topicId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (topicId != null ? topicId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    public Topics getTopicsByTopicId() {
        return topicsByTopicId;
    }

    public void setTopicsByTopicId(Topics topicsByTopicId) {
        this.topicsByTopicId = topicsByTopicId;
    }
}
