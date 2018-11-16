package demo.graphql.common.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class User
{
    @Id
    private long id;
    private String name;
    private Integer age;
    private String address;
    private LocalDateTime createdAt;

    public User() {}

    public User(long id, String name, int age, String address, LocalDateTime createdAt)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.createdAt = createdAt;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }
}
