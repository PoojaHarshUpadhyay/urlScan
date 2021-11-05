package com.urlscan.urlscan.model;

import javax.persistence.*;

@Entity
@Table(name = "userurl")
public class UserUrl {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "url")
    private String url;

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "UserUrl{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
