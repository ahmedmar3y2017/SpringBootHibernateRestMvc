package springboothibernate.Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ahmed on 7/22/2017.
 */
@Entity
public class Topics {
    private String id;
    private String description;
    private String username;

    public Topics() {

    }

    public Topics(String id, String description, String username) {
        this.id = id;
        this.description = description;
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topics topics = (Topics) o;

        if (id != null ? !id.equals(topics.id) : topics.id != null) return false;
        if (description != null ? !description.equals(topics.description) : topics.description != null) return false;
        if (username != null ? !username.equals(topics.username) : topics.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }


}
