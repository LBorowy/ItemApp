package pl.lborowy.itemapp;

/**
 * Created by RENT on 2017-08-02.
 */

public interface MainContract {

    interface Presenter {
        void onOpenDialogPressed();
    }

    interface View {
        void openAddDialog();
    }
}
