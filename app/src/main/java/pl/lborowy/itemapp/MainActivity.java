package pl.lborowy.itemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this); // dzięki temu mozna korzystać z Realm

        Book book = new Book(0, "Był sobie szpieg", new Author(0, "Keith", "Thomson"), "666"); // obiekt książki
        Realm realm = Realm.getDefaultInstance(); // zeby zapisywac, trzeba stworzyc obiekt Realm

        realm.beginTransaction(); // otwarcie transakcji
        realm.copyToRealm(book); // wysypie się bez transakcji
        realm.commitTransaction(); // zamknięcie transakcji

        RealmResults<Book> books = realm.where(Book.class).findAll(); // znajduje wszystkie obiekty
        // w klasie Book   --  books jest teraz kolekcją

        Log.d("Tag", books.toString());
    }
}
