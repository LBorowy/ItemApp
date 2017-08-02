package pl.lborowy.itemapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.itemapp.Fragment.AddItemFragment;


public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.main_activity_fab)
    FloatingActionButton floatingActionButton;
    private MainContract.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // cała logika idzie do Presentera

        mainPresenter = new MainPresenter(this); // 1 prezenter przypisany do całego Activity


    }

    @OnClick(R.id.main_activity_fab)
    public void onFabPressed() {
        mainPresenter.onOpenDialogPressed();
    }

    @Override
    public void openAddDialog() {
        // tu jest nasze View
        AddItemFragment.newInstance().show(getSupportFragmentManager(), "");
    }
}
