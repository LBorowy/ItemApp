package pl.lborowy.itemapp.Fragment;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import pl.lborowy.itemapp.Model.Item;

/**
 * Created by RENT on 2017-08-01.
 */

public class AddItemPresenter implements AddItemContract.Presenter {

    // logika dodawania

    private final AddItemContract.View view;
    private Realm realm;

    public AddItemPresenter(AddItemContract.View view) {
        this.view = view;
    }

    @Override
    public void saveItem(Realm realm) {
        // zapisujemy
        final String name = view.getItemName();
        final String description = view.getItemDescription();

        // zapisywanie obiektu do Realmu
        final Item item = new Item(generateId(realm), name, description, new Date().getTime());
        saveItemToRealm(realm, item);

        // taka forma zapisywania lub tak jak w metodzie saveItemToRealm
//        realm.beginTransaction();
//        Item item = new Item(-1, name, description, new Date().getTime());
//        realm.copyToRealm(item);
//        realm.commitTransaction();

    }

    private int generateId(Realm realm) {
        // 1 najwyzsze id z bazy


        Number maxNumber = realm.where(Item.class).max("id");
        if (maxNumber != null) {
            return maxNumber.intValue() + 1;
        }
        else {
            return Integer.MIN_VALUE;
        }
        // if inaczej
//        return maxNumber != null ? maxNumber.intValue() + 1 : Integer.MIN_VALUE;

//        Item itemMaxId = realm.where(Item.class).findFirst(); // zwraca element Item
//        if (itemMaxId != null) {
//            int maxId = realm.where(Item.class).max("id").intValue();
//            return maxId + 1;
//        }
//        else {
//            return Integer.MIN_VALUE;
//        }
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
