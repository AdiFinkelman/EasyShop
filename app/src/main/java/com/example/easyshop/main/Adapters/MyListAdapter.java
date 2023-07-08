package com.example.easyshop.main.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> implements Save_Callback {
    private MyList myList;
    private Save_Callback save_callback;

    public MyListAdapter(MyList myList, Save_Callback save_callback) {
        this.save_callback = save_callback;
        this.myList = myList;
        if (myList == null) {
            myList = new MyList(null, "0");
            myList.setName("EasyShop");
        }
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item, parent, false);
        MyListViewHolder listViewHolder = new MyListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {
        Item item = getItem(position);
        holder.myList_TXT_name.setText(item.getName());
        holder.myList_TXT_price.setText(DataManager.getDfFormat(item.getPrice()) + " ₪");
        holder.myList_TXT_quantity.setText(item.getQuantity() + "");
        holder.myListItem_LAYOUT.setOnClickListener(v -> {
            deleteItemFromFirebase(item.getName());
            Log.d("", "ITEM: " + item.getName());
            if (myList.getList().size() == 1)
                myList.getList().clear();
            else
                myList.getList().remove(position);
            notifyItemRemoved(position);
        });
    }

    private void deleteItemFromFirebase(String itemKey) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("list").child(itemKey);

        reference.removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        SignalGenerator.getInstance().toast("Item deleted successfully", Toast.LENGTH_SHORT);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        SignalGenerator.getInstance().toast("Failed to delete item", Toast.LENGTH_SHORT);
                    }
                });
    }


    @Override
    public int getItemCount() {
        return this.myList.getList() == null || this.myList == null ? 0 : this.myList.getList().size();
    }

    private Item getItem(int position) {
        return this.myList.getList().get(position);
    }

    @Override
    public void onSaveClicked(ArrayList<Item> itemsList) {
        myList.getList().addAll(itemsList);
        notifyDataSetChanged();
    }

    public class MyListViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView myList_TXT_name;
        private AppCompatTextView myList_TXT_price;
        private AppCompatTextView myList_TXT_quantity;
        private ConstraintLayout myListItem_LAYOUT;


        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            myList_TXT_name = itemView.findViewById(DataManager.getMyListItem_TXT_name());
            myList_TXT_price = itemView.findViewById(DataManager.getMyListItem_TXT_price());
            myList_TXT_quantity = itemView.findViewById(DataManager.getMyListItem_TXT_quantity());
            myListItem_LAYOUT = itemView.findViewById(DataManager.getMyListItem_LAYOUT());
        }
    }
}
