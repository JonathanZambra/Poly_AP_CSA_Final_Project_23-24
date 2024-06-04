package com.poly.polyapcsafinalproject23_24;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseGameFragment extends Fragment {

    public Context context;

    private RecyclerView recyclerView;
    private ArrayList<ModelGame> gameList;

    public static ChooseGameFragment newInstance(ArrayList<ModelGame> gameList) {
        ChooseGameFragment fragment = new ChooseGameFragment();
        fragment.gameList = gameList;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = getActivity();
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        gameList = new ArrayList<ModelGame>();
        gameList.add(new ModelGame("Mr.", "Burke", "Labor Day Weekend", new GameLaborDayAdventure()));
        gameList.add(new ModelGame("Mr.", "Burke", "Hot Dog Eating Contest", new GameHotDogEatingContest()));
        gameList.add(new ModelGame("Jonathan", "Zambrano", "Fisherman Simulator", new GameZambranoJonathan()));


        RecyclerViewAdapterGame adapter = new RecyclerViewAdapterGame(this.context, this.gameList);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new RecyclerViewAdapterGame.OnItemClickListener() {
            public void onItemClick(ModelGame model) {
                Log.d("Clicked", model.getGameName());
                startActivity(new Intent(ChooseGameFragment.this.context, model.getActivity().getClass()));
            }
        });
    }
}
