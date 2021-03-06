package fr.pmobile.watchlist;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    @BindView(R.id.rv_mainup)
    RecyclerView rView;

    private ArrayList<Film> listFilm = new ArrayList<>();

    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addAdapterItem();
        showRecycleListSec();
    }

    private void addAdapterItem(){
        FilmData filmData = new FilmData(getActivity());
        listFilm = filmData.getListFilm("2");
    }

    private void showRecycleList(){
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FilmAdapter filmAdapter = new FilmAdapter(getActivity());
        filmAdapter.setListFilm(listFilm);
        rView.setAdapter(filmAdapter);
    }

    private void showRecycleListSec(){
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getActivity());
        recycleViewAdapter.swipemode = 1;
        ((RecycleViewAdapter) recycleViewAdapter).setMode(Attributes.Mode.Single);
        recycleViewAdapter.setListFilm(listFilm);
        recycleViewAdapter.setBookmarkStatSize(listFilm.size());
        rView.setAdapter(recycleViewAdapter);
    }
}
