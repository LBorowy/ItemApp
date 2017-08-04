package pl.lborowy.itemapp.Model;



import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by RENT on 2017-08-01.
 */

public class Basement extends RealmObject {

    @PrimaryKey
//    @Required
    private int id;


    private RealmList<Item> items;
    private String name;

    public Basement() {
        // required empty constructor
    }

    public Basement(int id, RealmList<Item> items, String name) {
        this.id = id;
        this.items = items;
        this.name = name;
    }

    public Basement(int id, String name) {
        this.name = name;
        this.id = id;
    }
}
