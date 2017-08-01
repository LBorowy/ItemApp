package pl.lborowy.itemapp.Fragment;

import io.realm.Realm;

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
        String name = view.getItemName();
        String description = view.getItemDescription();
    }
}
