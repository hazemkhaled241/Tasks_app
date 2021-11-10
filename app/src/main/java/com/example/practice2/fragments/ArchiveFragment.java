package com.example.practice2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practice2.R;
import com.example.practice2.TaskAdapter;

import java.util.List;


public class ArchiveFragment extends Fragment {
List list;
RecyclerView recyclerView;
    public ArchiveFragment(List list) {
        this.list = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_archive, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.rv_archive_tasks);
        TaskAdapter taskAdapter=new TaskAdapter(list,true,false);
        recyclerView.setAdapter(taskAdapter);
    }
}