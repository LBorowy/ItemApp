package pl.lborowy.itemapp.Fragment;

import io.realm.Realm;

/**
 * Created by RENT on 2017-08-01.
 */

interface AddItemContract {
    interface Presenter {

        void saveItem(Realm realm);
    }

    interface View {

        void closeDialog();

        String getItemName();

        String getItemDescription();
    }
}
