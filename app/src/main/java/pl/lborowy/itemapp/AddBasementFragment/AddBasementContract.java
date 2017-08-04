package pl.lborowy.itemapp.AddBasementFragment;

import io.realm.Realm;

/**
 * Created by RENT on 2017-08-04.
 */

public interface AddBasementContract {

    interface View {

        void closeDialog();

        String getBasementName();
    }

    interface Presenter {

        void onSaveClicked(Realm realm);
    }
}
