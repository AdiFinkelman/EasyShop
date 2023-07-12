package com.example.easyshop.main.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyshop.R;
import com.example.easyshop.main.Adapters.ListAdapter;
import com.example.easyshop.main.Interfaces.Save_Callback;
import com.example.easyshop.main.Interfaces.Spinner_Callback;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Models.LoginActivity;
import com.example.easyshop.main.Models.RegisterActivity;
import com.example.easyshop.main.Object.CreatedList;
import com.example.easyshop.main.Object.Item;
import com.example.easyshop.main.Object.MyList;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListFragment extends Fragment implements Spinner_Callback {

    private RecyclerView created_RV_LST;
    private CreatedList createdList;
    private AppCompatButton clear_BTN;
    private AppCompatButton save_BTN;
    private ArrayList<Item> newList = new ArrayList<>();
    private ArrayList<Item> myList = DataManager.getMyList();
    private Save_Callback save_callback;
    private ListAdapter listAdapter = new ListAdapter(createdList, save_callback);

    public ListFragment(Save_Callback save_callback){
        this.save_callback = save_callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews(view);
        saveToMyList();
        clearCreatingList();
        return view;
    }

    private void initViews(View view) {
        newList = new ArrayList<>();
        createdList = new CreatedList(newList);
        listAdapter = new ListAdapter(createdList, save_callback);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        created_RV_LST.setAdapter(listAdapter);
        created_RV_LST.setLayoutManager(linearLayoutManager);
    }

    private void findViews(View view) {
        created_RV_LST = view.findViewById(DataManager.getToList_RV_list());
        clear_BTN = view.findViewById(DataManager.getToList_BTN_clear());
        save_BTN = view.findViewById(DataManager.getToList_btn_save());
    }

    public void addItem(Item selectedItem) {
        boolean isItemExist = false;
        for (Item item : newList) {
            if (item.getName().equals(selectedItem.getName()) && item.getQuantity() != 0) {
                item.setQuantity(selectedItem.getQuantity());
                item.setPrice(selectedItem.getPrice());
                isItemExist = true;
            }
        }
        if (!isItemExist)
            newList.add(selectedItem);

        listAdapter.notifyDataSetChanged();
        initCreationFragmentView();
        Log.d("" , "NEW LIST " + newList.toString());
    }

    public void saveToMyList() {
        save_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.addAll(newList);

                String regEmail = RegisterActivity.userEmail;
                String loginEmail = LoginActivity.userEmail;
                String userEmail;
                if (regEmail != null)
                    userEmail = regEmail;
                else
                    userEmail = loginEmail;

                saveToFirebase(userEmail);

                SignalGenerator.getInstance().vibrate(400);
                SignalGenerator.getInstance().toast("You added " + newList.size() + " items", Toast.LENGTH_SHORT);
                newList.clear();
                initViews(v);
                initCreationFragmentView();

                if (save_callback != null) {
                    save_callback.onSaveClicked(myList);
                }
            }
        });
    }

    private void saveToFirebase(String userEmail) {

        MyList list = new MyList().setList(myList).setUserEmail(userEmail);
        myList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("lists");

        // Check if the list already exists based on a unique identifier
        reference.orderByChild("userEmail").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // List already exists, update its data
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String key = childSnapshot.getKey();
                        if (key != null) {
                            MyList tempList = childSnapshot.getValue(MyList.class);
                            tempList.getList().addAll(list.getList());
                            reference.child(key).setValue(tempList)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            SignalGenerator.getInstance().toast("My List updated successfully", Toast.LENGTH_SHORT);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            SignalGenerator.getInstance().toast("Failed to update My List", Toast.LENGTH_SHORT);
                                        }
                                    });
                        }
                    }
                } else {
                    // List doesn't exist, create a new entry
                    String key = reference.push().getKey();
                    if (key != null) {
                        reference.child(key).setValue(list)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        SignalGenerator.getInstance().toast("My List created successfully", Toast.LENGTH_SHORT);
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        SignalGenerator.getInstance().toast("Failed to create My List", Toast.LENGTH_SHORT);
                                    }
                                });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                SignalGenerator.getInstance().toast("Error retrieving My List data", Toast.LENGTH_SHORT);
            }
        });
    }

    private void clearCreatingList() {
        clear_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newList.clear();
                SignalGenerator.getInstance().vibrate(100);
                initViews(v);
                initCreationFragmentView();
            }
        });
    }

    public void initCreationFragmentView() {
        CreationFragment creationFragment = new CreationFragment();
        creationFragment.setSpinner_callback(ListFragment.this);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_FRAME_creation, creationFragment)
                .commit();
    }

    @Override
    public void spinnerClicked(Item selectedItem) {
        addItem(selectedItem);
    }
}