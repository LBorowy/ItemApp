package pl.lborowy.itemapp.ListFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;
import pl.lborowy.itemapp.Model.Item;
import pl.lborowy.itemapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsListFragment extends Fragment {

    @BindView(R.id.list_fragment_recyclerview)
    RecyclerView recyclerView;

    private Realm realm;


    public static ItemsListFragment newIstance() {

        return new ItemsListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        realm = Realm.getDefaultInstance();
        // pobieranie rzeczy z realma
        RealmResults<Item> items = realm.where(Item.class).findAll();
    }
}
