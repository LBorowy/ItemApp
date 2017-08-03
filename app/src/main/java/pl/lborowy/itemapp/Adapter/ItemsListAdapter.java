package pl.lborowy.itemapp.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import pl.lborowy.itemapp.Model.Item;
import pl.lborowy.itemapp.R;

/**
 * Created by RENT on 2017-08-03.
 */

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemViewHolder> {

    private final RealmResults<Item> items;

    public ItemsListAdapter(RealmResults<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // tworzenie ViewHoldera
        // podpiecie xml do view (inflater)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itmes_list_row, null, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        // przypisywane rzeczy z naszych danych do viewholdera (pozycja na liscie)
        Item item = items.get(position);
        // co chcemy z nim zrobić
        holder.itemTitle.setText(item.getName());
        holder.itemId.setText(String.valueOf(item.getId()));

    }

    @Override
    public int getItemCount() {
        // długość listy
        return items.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_id)
        TextView itemId;
        @BindView(R.id.item_title)
        TextView itemTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
