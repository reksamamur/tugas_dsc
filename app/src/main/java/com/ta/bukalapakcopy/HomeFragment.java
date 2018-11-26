package com.ta.bukalapakcopy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RvSpecialAdapter rvSpecialAdapter;
    ArrayList<Special> specialArrayList = new ArrayList<>();
    NestedScrollView nestedScrollView;
    LinearLayout linearLayoutDana;
    AppCompatButton appCompatButtonSearch;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = v.findViewById(R.id.toolbartop);
        toolbar.inflateMenu(R.menu.n_menu);
        Menu menu = toolbar.getMenu();

        recyclerView = v.findViewById(R.id.rv_spesial);

        specialArrayList.add(new Special(R.drawable.slide1));
        specialArrayList.add(new Special(R.drawable.slide2));

        rvSpecialAdapter = new RvSpecialAdapter(getActivity(), specialArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(rvSpecialAdapter);

        nestedScrollView = v.findViewById(R.id.nested_view);
        linearLayoutDana = v.findViewById(R.id.btn_dana);
        appCompatButtonSearch = v.findViewById(R.id.btn_search_top);
        initScroll();
        return v;
    }

    public void initScroll() {
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int x, int y, int ox, int oy) {
                if (y > oy) {
                    linearLayoutDana.setVisibility(View.GONE);
                    appCompatButtonSearch.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutDana.setVisibility(View.VISIBLE);
                    appCompatButtonSearch.setVisibility(View.GONE);
                }
            }
        });
    }

}
