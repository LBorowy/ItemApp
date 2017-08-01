package pl.lborowy.itemapp;

import io.realm.RealmObject;

/**
 * Created by RENT on 2017-08-01.
 */

public class Book extends RealmObject {

    private int id;
    private String title;
    private Author author; // relacja 1 do 1
    private String isbn;

    public Book() {
        // required empty constructor
    }

    public Book(int id, String title, Author author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
