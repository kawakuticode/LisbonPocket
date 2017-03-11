package kawakuticode.worldpocket.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisbonpocket.code.kawakuti.worldpocket.R;

import java.util.ArrayList;
import java.util.List;

import kawakuticode.worldpocket.model.Item;

/**
 * Created by russeliusernestius on 29/12/16.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements View.OnClickListener {

    private List<Item> mItems;
    private Listener mListener;

    public ItemAdapter(List<Item> items, Listener listener) {
        super();
        if ( items==null ){
            mItems= new ArrayList<>();
        }
        this.mItems =items;
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Item item = mItems.get(i);
        Log.e("ITEM --> "+i , item.getType());

        viewHolder.item_name.setText(item.getType());
        viewHolder.icon.setImageResource(item.getIcon());

        if (mListener != null) {
            viewHolder.cardView.setOnClickListener(this);
            viewHolder.cardView.setTag(item);
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public ImageView icon;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.item_icon);
            item_name = (TextView) itemView.findViewById(R.id.text);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof CardView) {
            Item item = (Item) view.getTag();
            mListener.onItemClicked(item);
        }
    }

    public List<Item> getItems() {
        return mItems;
    }


    public interface Listener {
        void onItemClicked(Item item);
    }
}

