package com.lanou.project.chanyouji.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanou.project.chanyouji.Adapter.AuthoroneAdapter;
import com.lanou.project.chanyouji.Class.Trips;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.MyListView;

import java.util.List;



/**
 * Created by lanouhn on 16/9/27.
 */
public class AuthoroneFragment extends Fragment {
    MyListView listView;
    View view;
    List<Trips> tripsbentList;
    AuthoroneAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.tnf_layout,null);
        initView();
        Bundle bundle=getArguments();
        tripsbentList=bundle.getParcelableArrayList("made");
        initData();
        return view;
    }

    private void initView() {
        listView = (MyListView) view.findViewById(R.id.gridview);
    }

    private void initData() {
        adapter=new AuthoroneAdapter(getActivity(),tripsbentList);
        listView.setAdapter(adapter);
    }
}
