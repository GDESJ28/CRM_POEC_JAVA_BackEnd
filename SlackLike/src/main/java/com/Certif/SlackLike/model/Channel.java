package com.Certif.SlackLike.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="channels")
public class Channel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false,length = 50)
    private String  name;

    @Column(name="creation_date",nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private Integer status;

    public Channel() {
    }

    public Channel(String name, LocalDateTime creationDate, Integer status) {
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", status=" + status +
                '}';
    }
}
