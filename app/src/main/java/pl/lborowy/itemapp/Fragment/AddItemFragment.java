package pl.lborowy.itemapp.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.itemapp.R;

public class AddItemFragment extends DialogFragment {

    @BindView(R.id.add_item_name)
    EditText name;
    @BindView(R.id.add_item_description)
    EditText description;

    private AddItemContract.Presenter addItemPresenter;

    public AddItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addItemPresenter = new AddItemPresenter();
    }

    @OnClick(R.id.add_item_button_save)
    public void onSaveButtonClicked() {
        // przekazywanie prezenterowi o kliknieciu przycisku
        
    }



}
