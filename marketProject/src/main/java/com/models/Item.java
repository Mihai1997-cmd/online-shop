package com.models;

import javax.persistence.*;

@Entity(name="item") // Adnotare JPA pentru a face obiectul gata de salvat intr-o baza de stocare JPA
@Table(name="items")
public class Item {

    @Id // indica ca este un primary key si il auto populeaza JPA
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column
    private final long IdModelAuto;

    @Column
    private final String name;

    @Column
    private final String description;

    @Column
    private final int pret;

    @Column
    private final String imageUrl;

    @Column
    private final int cantitate;

    public Item() {
        this.ID = ID;
        this.IdModelAuto = 0;
        this.name = null;
        this.description = null;
        this.pret = 0;
        this.imageUrl = null;
        this.cantitate = 0;
    }

    public Item(long id, long IdModelAuto, String name, String description, int pret, String imageUrl, int cantitate) {
        this.ID = id;
        this.IdModelAuto = IdModelAuto;
        this.name = name;
        this.description = description;
        this.pret = pret;
        this.imageUrl =imageUrl;
        this.cantitate = cantitate;
    }



    public void setId(long id) {
        this.ID = id;
    }

    public long getID() {
        return ID;
    }

    public long getIdModelAuto() {
        return IdModelAuto;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPret() {
        return pret;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCantitate() {
        return cantitate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", IdModelAuto=" + IdModelAuto +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pret='" + pret + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cantitate='" + cantitate + '\'' +
                '}';
    }
// standard constructors / setters / getters / toString

}

