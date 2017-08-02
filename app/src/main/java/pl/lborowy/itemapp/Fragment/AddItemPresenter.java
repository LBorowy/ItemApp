package pl.lborowy.itemapp.Fragment;

import java.util.Date;

import io.realm.Realm;
import pl.lborowy.itemapp.Model.Item;

/**
 * Created by RENT on 2017-08-01.
 */

public class AddItemPresenter implements AddItemContract.Presenter {

    private final AddItemContract.View view;

    public AddItemPresenter(AddItemContract.View view) {
        this.view = view;
    }

    @Override
    public void saveItem(Realm realm) {
        // zapisujemy
        final String name = view.getItemName();
        final String description = view.getItemDescription();

        // zapisywanie obiektu do Realmu
        final Item item = new Item(-1, name, description, new Date().getTime());
        saveItemToRealm(realm, item);

        // taka forma zapisywania lub tak jak w metodzie saveItemToRealm
//        realm.beginTransaction();
//        Item item = new Item(-1, name, description, new Date().getTime());
//        realm.copyToRealm(item);
//        realm.commitTransaction();


    }

    private void saveItemToRealm(Realm realm, final Item item) {
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm innerRealm) {
//
//                innerRealm.copyToRealm(item);
//            }
//        });
        // lambdą..
        realm.executeTransaction(
                innerRealm -> innerRealm.copyToRealm(item));
    }
}
