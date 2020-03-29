package com.example.drakorsyn.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drakorsyn.R;
import com.example.drakorsyn.adapters.ItemCardViewAdapter;
import com.example.drakorsyn.adapters.ItemGridAdapter;
import com.example.drakorsyn.adapters.ItemListAdapter;
import com.example.drakorsyn.models.Drakor;
import com.example.drakorsyn.models.DrakorData;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Drakor> list;

    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";

    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
//        list.addAll(DrakorData.getListData());
//        showRecyclerViewList();

        if (savedInstanceState == null) {
            setActionBarTitle("ListView DrakorSyn");
            list.addAll(DrakorData.getListData());
            showRecyclerViewList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Drakor> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        String title = null;
        switch (itemId) {
            case R.id.action_list:
                title = "ListView DrakorSyn";
                showRecyclerViewList();
                break;
            case R.id.action_grid:
                title = "GridView DrakorSyn";
                showRecyclerViewGrid();
                break;
            case R.id.action_cardview:
                title = "CardView DrakorSyn";
                showRecyclerCardView();
                break;
        }
        mode = itemId;
        setActionBarTitle(title);
    }

    private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemCardViewAdapter cardViewAdapter = new ItemCardViewAdapter(this);
        cardViewAdapter.setListDrakor(list);
        recyclerView.setAdapter(cardViewAdapter);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerViewGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ItemGridAdapter gridAdapter = new ItemGridAdapter(this);
        gridAdapter.setListDrakor(list);
        recyclerView.setAdapter(gridAdapter);
    }

    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemListAdapter listAdapter = new ItemListAdapter(this);
        listAdapter.setListDrakor(list);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
