package pl.lborowy.itemapp;

/**
 * Created by RENT on 2017-08-02.
 */

public interface MainContract {

    interface Presenter {
        void onViewInitialized();

        void onOpenItemDialogPressed();

        void notifyDialogClosed();

        void onOpenBasementDialogPressed();
    }

    interface View {
        void openItemAddDialog();

        void openBasementAddDialog();

        void showList();

        void refreshList();
    }
}
