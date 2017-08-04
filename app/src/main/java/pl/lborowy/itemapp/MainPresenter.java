package pl.lborowy.itemapp;


/**
 * Created by RENT on 2017-08-02.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) { // do połączenia View <-> Presenter
        this.view = view;
    }

    @Override
    public void onViewInitialized() {
        view.showList();
    }

    @Override
    public void onOpenItemDialogPressed() {
        // tutaj nie możemy odpalić dialogu -> lecimy do View (MainActivity - openItemAddDialog());
        view.openItemAddDialog();
    }

    @Override
    public void notifyDialogClosed() {
        view.refreshList();
    }

    @Override
    public void onOpenBasementDialogPressed() {
        view.openBasementAddDialog();
    }
}
