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
        view.closeDialog();

        // taka forma zapisywania lub tak jak w metodzie saveItemToRealm
//        realm.beginTransaction();
//        Item item = new Item(-1, name, description, new Date().getTime());
//        realm.copyToRealm(item);
//        realm.commitTransaction();

    }

    private int generateId(Realm realm) {
        // 1 najwyzsze id z bazy


        Number maxNumber = realm.where(Item.class).max("id");
        return maxNumber != null ? maxNumber.intValue() + 1 : Integer.MIN_VALUE;
//        if (maxNumber != null) {
//            return maxNumber.intValue() + 1;
//        } else {
//            return Integer.MIN_VALUE;
//        }
        // if inaczej


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
//        realm.executeTransaction(
//                innerRealm -> innerRealm.copyToRealm(item));

        // synchroniczne
//        realm.executeTransaction(innerRealm -> innerRealm.copyToRealm(item));

        // asynchronicznie
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(item);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                view.closeDialog();
//            }
//        });

        // asynchroniczine
        realm.executeTransactionAsync(realm1 -> {
            realm1.copyToRealm(item);
        }, view::closeDialog);


    }
}
