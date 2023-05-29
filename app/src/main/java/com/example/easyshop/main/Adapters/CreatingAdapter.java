package com.example.easyshop.main.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.CreationList;
import com.example.easyshop.main.Models.Item;

//public class CreatingListAdapter extends BaseAdapter {
//    Context context;
//    String namesList[];
//    String pricesList[];
//
//    ArrayList<Item> categoryItems;
//    LayoutInflater inflater;
//
//    public CreatingListAdapter(Context context, String namesList[], String pricesList[]) {
//        this.context = context;
//        this.namesList = namesList;
//        this.pricesList = pricesList;
//        this.categoryItems = categoryItems;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return namesList.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = inflater.inflate(R.layout.category_item, null);
//        TextView name = (TextView) convertView.findViewById(R.id.category_TXT_name);
//        TextView price = (TextView) convertView.findViewById(R.id.category_TXT_price);
//        name.setText(namesList[position]);
//        price.setText(pricesList[position]);
//        return convertView;
//    }
//}

public class CreatingAdapter extends RecyclerView.Adapter<CreatingAdapter.CreatingViewHolder> {
    private CreationList creationList;

    public CreatingAdapter(CreationList creationList) {
        this.creationList = creationList;
        if (creationList == null) {
            creationList = new CreationList(null);
            creationList.setName("EasyShop");
        }
    }

    @NonNull
    @Override
    public CreatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CreatingViewHolder recordViewHolder = new CreatingViewHolder(view);
        return recordViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreatingViewHolder holder, int position) {
        Item item = getItem(position);
        holder.category_TXT_name.setText(item.getName());
        holder.category_TXT_price.setText(item.getPrice() + "$ per Kg");

        initSpinner(holder);
    }

    private void initSpinner(CreatingViewHolder holder) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(holder.itemView.getContext(), R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner_quantity.setAdapter(adapter);
        holder.spinner_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.creationList == null ? 0 : this.creationList.getCategory().size();
    }

    private Item getItem(int position) {
        return this.creationList.getCategory().get(position);
    }

    public class CreatingViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView category_TXT_name;
        private AppCompatTextView category_TXT_price;
        private Spinner spinner_quantity;


        public CreatingViewHolder(@NonNull View itemView) {
            super(itemView);
            category_TXT_name = itemView.findViewById(DataManager.getCategory_TXT_name());
            category_TXT_price = itemView.findViewById(DataManager.getCategory_TXT_price());
            spinner_quantity = itemView.findViewById(DataManager.getSpinner_quantity());
        }
    }

}
