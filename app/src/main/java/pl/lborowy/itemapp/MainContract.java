package pl.lborowy.itemapp;

/**
 * Created by RENT on 2017-08-02.
 */

public interface MainContract {

    interface Presenter {
        void onViewInitialized();

        void onOpenDialogPressed();

        void notifyDialogClosed();

    }

    interface View {
        void openAddDialog();

        void showList();

        void refreshList();
    }
}
