package com.example.easyshop.main.Adapters;

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
import com.example.easyshop.main.Models.LoginActivity;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> implements Save_Callback {
    private final MyList myList;
    private final Save_Callback save_callback;

    public MyListAdapter(MyList myList, Save_Callback save_callback) {
        this.save_callback = save_callback;
        this.myList = myList;
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
        if (DataManager.isPriceWithWeight(item))
            holder.myList_TXT_quantity.setText(item.getQuantity() + " kg");
        else
            holder.myList_TXT_quantity.setText(item.getQuantity() + "");
        holder.myListItem_LAYOUT.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (myList.getList().size() == 1)
                myList.getList().clear();
            else
                myList.getList().remove(currentPosition);
            notifyItemRemoved(currentPosition);
            deleteFromFirebase();
            save_callback.onSaveClicked(myList.getList());
        });
    }

    private void deleteFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("lists");
        reference.orderByChild("userEmail").equalTo(LoginActivity.userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String key = childSnapshot.getKey();
                        if (key != null) {
                            reference.child(key).setValue(myList);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                SignalGenerator.getInstance().toast("Error retrieving My List data", Toast.LENGTH_SHORT);
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
