package pl.lborowy.itemapp.AddBasementFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.itemapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBasementFragment extends DialogFragment implements AddBasementContract.View {

    @BindView(R.id.add_basement_name)
    EditText name;
    private AddBasementContract.Presenter presenter;


    public static AddBasementFragment newInstance() {
        return new AddBasementFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_basement, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AddBasementPresenter(); // korzystanie z metod zadeklarowanych w interfejsie
    }

    @OnClick(R.id.add_basement_save_button)
    public void onSaveButtonClicked() {
        presenter.onSaveClicked();
    }

    @Override
    public void closeDialog() {
        this.dismiss();
    }

}
