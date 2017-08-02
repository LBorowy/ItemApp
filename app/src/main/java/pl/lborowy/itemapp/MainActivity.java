package pl.lborowy.itemapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.main_activity_fab)
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // cała logika idzie do Presentera

    }

    @OnClick(R.id.main_activity_fab)
    public void onFabPressed() {

    }


    @Override
    public void openAddDialog() {

    }
}
