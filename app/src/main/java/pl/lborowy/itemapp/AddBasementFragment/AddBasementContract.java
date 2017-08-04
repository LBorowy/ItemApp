package pl.lborowy.itemapp.AddBasementFragment;

/**
 * Created by RENT on 2017-08-04.
 */

public interface AddBasementContract {

    interface View {

        void closeDialog();
    }

    interface Presenter {

        void onSaveClicked();
    }
}
