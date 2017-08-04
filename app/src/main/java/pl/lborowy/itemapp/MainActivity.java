package pl.lborowy.itemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.itemapp.AddBasementFragment.AddBasementFragment;
import pl.lborowy.itemapp.Fragment.AddItemFragment;
import pl.lborowy.itemapp.ListFragment.ItemsListFragment;


public class MainActivity extends AppCompatActivity implements MainContract.View, AddDialogInterface{


    private MainContract.Presenter mainPresenter;
    private ItemsListFragment itemsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // cała logika idzie do Presentera

        mainPresenter = new MainPresenter(this); // 1 prezenter przypisany do całego Activity
        itemsListFragment = ItemsListFragment.newInstance(); // inicjalizacja
        mainPresenter.onViewInitialized(); // inicjalizacja

        // adapter cd pokazywanie
//        ItemsListFragment itemsListFragment = ItemsListFragment.newInstance();
//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.main_activity_container, itemsListFragment)
//                .commit();


    }

    @OnClick(R.id.main_activity_menu_fab_item)
    public void onItemFabPressed() {
        mainPresenter.onOpenItemDialogPressed();
    }

    @OnClick(R.id.main_activity_menu_fab_basement)
    public void onBasementFabPressed() {
        mainPresenter.onOpenBasementDialogPressed();
    }

    @Override
    public void openItemAddDialog() {
        // tu jest nasze View
        AddItemFragment.newInstance().show(getSupportFragmentManager(), "");
    }

    @Override // do View
    public void openBasementAddDialog() {
        AddBasementFragment.newInstance().show(getSupportFragmentManager(), "");
    }

    @Override
    public void showList() {
        // adapter cd pokazywanie
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, itemsListFragment)
                .commit();
    }

    @Override
    public void refreshList() {
        itemsListFragment.refreshList();
    }

    @Override
    public void onDialogDismiss() {
        // w momencie, kiedy dialog sie zamknie powinniśmy powiadomic presenter, ze zostal zamkniety
        // dialog -> Activity -> Presenter -> powrót do Activity (zamknij dialog)
        mainPresenter.notifyDialogClosed();
    }
}
