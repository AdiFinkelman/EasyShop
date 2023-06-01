package com.example.easyshop.main.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Object.CreatedList;
import com.example.easyshop.main.Object.Item;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> implements Spinner_Callback {
    private CreatedList createdList;

    public ListAdapter(CreatedList createdList, Save_Callback save_callback) {
        this.createdList = createdList;
        if (createdList == null) {
            createdList = new CreatedList(null);
            createdList.setName("EasyShop");
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Item item = getItem(position);
        holder.myListItem_TXT_name.setText(item.getName());
        holder.myListItem_TXT_price.setText(item.getPrice() + "$");
        holder.myListItem_TXT_quantity.setText(item.getQuantity() + "");
    }

    @Override
    public int getItemCount() {
        return this.createdList.getList() == null || this.createdList == null ? 0 : this.createdList.getList().size();
    }

    private Item getItem(int position) {
        return this.createdList.getList().get(position);
    }

    @Override
    public void spinnerClicked(Item selectedItem) {
        createdList.getList().add(selectedItem);
        notifyDataSetChanged();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView myListItem_TXT_name;
        private AppCompatTextView myListItem_TXT_price;
        private AppCompatTextView myListItem_TXT_quantity;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            myListItem_TXT_name = itemView.findViewById(DataManager.getMyListItem_TXT_name());
            myListItem_TXT_price = itemView.findViewById(DataManager.getMyListItem_TXT_price());
            myListItem_TXT_quantity = itemView.findViewById(DataManager.getMyListItem_TXT_quantity());
        }
    }
}
