package com.example.easyshop.main.Adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.CategoryList;
import com.example.easyshop.main.Models.CreatedList;
import com.example.easyshop.main.Models.Item;

public class CreatingAdapter extends RecyclerView.Adapter<CreatingAdapter.CreatingViewHolder> {
    private CategoryList categoryList;
    private Spinner_Callback spinner_callback;

    public CreatingAdapter(CategoryList categoryList, Spinner_Callback spinner_callback) {
        this.spinner_callback = spinner_callback;
        this.categoryList = categoryList;
        if (categoryList == null) {
            categoryList = new CategoryList(null);
            categoryList.setName("EasyShop");
        }
    }

    @NonNull
    @Override
    public CreatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CreatingViewHolder creatingViewHolder = new CreatingViewHolder(view);
        return creatingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreatingViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item item = getItem(position);
        holder.category_TXT_name.setText(item.getName());
        holder.category_TXT_price.setText(item.getPrice() + "$ per Kg");
        initSpinner(holder);
        //holder.item_LAYOUT.setOnClickListener(v -> spinnerClicked(categoryList.getCategory().get(holder.getAdapterPosition())));

//        holder.item_LAYOUT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Item selectedItem = categoryList.getCategory().get(position);
//                if (spinner_callback != null) {
//                    spinner_callback.spinnerClicked(selectedItem);
//                }
//            }
//        });
    }

    private void spinnerClicked(Item selectedItem) {
        if (spinner_callback != null)
            spinner_callback.spinnerClicked(selectedItem);
    }

    private void initSpinner(CreatingViewHolder holder) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(holder.itemView.getContext(), R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner_quantity.setAdapter(adapter);
        final boolean[] userSelection = {false};
        holder.spinner_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int quantity = Integer.parseInt(parent.getItemAtPosition(position).toString());
                Item selectedItem = categoryList.getCategory().get(holder.getAdapterPosition());
                selectedItem.setQuantity(quantity);
                Log.d("", "selectedItem" + selectedItem);
                Log.d("", "quantity" + quantity);
                spinner_callback.spinnerClicked(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.categoryList == null ? 0 : this.categoryList.getCategory().size();
    }

    private Item getItem(int position) {
        return this.categoryList.getCategory().get(position);
    }

    public class CreatingViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView category_TXT_name;
        private AppCompatTextView category_TXT_price;
        private Spinner spinner_quantity;
        private ConstraintLayout item_LAYOUT;


        public CreatingViewHolder(@NonNull View itemView) {
            super(itemView);
            category_TXT_name = itemView.findViewById(DataManager.getCategoryItem_TXT_name());
            category_TXT_price = itemView.findViewById(DataManager.getCategoryItem_TXT_price());
            spinner_quantity = itemView.findViewById(DataManager.getSpinner_quantity());
            item_LAYOUT = itemView.findViewById(R.id.Item_LAYOUT);
        }
    }

}
