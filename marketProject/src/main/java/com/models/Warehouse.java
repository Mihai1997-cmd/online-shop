package com.models;

import javax.persistence.*;

@Entity(name="warehouse")
@Table(name="warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private final String name;

    @Column
    private final long parentId;

    public Warehouse() {
        this.id = id;
        this.name = null;
        this.parentId=0;
    }

    public Warehouse(long id, String name, long parentId) {
        this.id = id;
        this.name = name;
        this.parentId=parentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }
    public long getParentId(){
        return parentId;
    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }

// standard constructors / setters / getters / toString

}

