package pl.lborowy.itemapp.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by RENT on 2017-08-01.
 */

public class Item extends RealmObject{

    @PrimaryKey
//    @Required
    private int id;


    private String name;
    private String description;
    private long insertionDate; // czas w ms

    public Item() {
        // required empty constructor
    }

    public Item(int id, String name, String description, long insertionDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.insertionDate = insertionDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
