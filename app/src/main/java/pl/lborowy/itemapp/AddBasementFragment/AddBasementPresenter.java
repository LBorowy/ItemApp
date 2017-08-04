package pl.lborowy.itemapp.AddBasementFragment;

import io.realm.Realm;
import pl.lborowy.itemapp.Model.Basement;

/**
 * Created by RENT on 2017-08-04.
 */

public class AddBasementPresenter implements AddBasementContract.Presenter {

    private final AddBasementContract.View view;

    public AddBasementPresenter(AddBasementContract.View view) {
        this.view = view; // view i crtl+alt+f
    }


    @Override
    public void onSaveClicked(Realm realm) {
        String name = view.getBasementName();
        Basement basement = new Basement(-1, name);

//        realm.executeTransaction(new Realm.Transaction() { // anonimowa implementacja interfejsu
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(basement);
//            }
//        });
//        view.closeDialog();


        // ansychroniczne wyjście lepsze dla moblinych wersji
//        realm.executeTransactionAsync(new Realm.Transaction() { // anonimowa implementacja interfejsu
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(basement);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                view.closeDialog();
//            }
//        });

        // to samo lambdą
        realm.executeTransactionAsync(realm1 -> {realm1.copyToRealm(basement);
        }, () -> {
            view.closeDialog();
        });
    }

    private int generateId(Realm realm) {
        Number maxNumber = realm.where(Basement.class).max("id");
        return maxNumber != null ? maxNumber.intValue() + 1 : Integer.MIN_VALUE;
    }
}
