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
    public void onOpenDialogPressed() {
        // tutaj nie możemy odpalić dialogu -> lecimy do View (MainActivity - openAddDialog());
        view.openAddDialog();
    }
}
