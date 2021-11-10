package com.example.practice2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.practice2.R;
import com.example.practice2.Task;
import com.example.practice2.TasksDatabase;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class InsertTaskSheetFragment extends BottomSheetDialogFragment {
EditText date,time,title;
    MaterialButton button;
    String stringDate,stringTime,stringTitle;
   public ArrayList<Task>list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_task_sheet, container, false);
    }

    @Override
    public void onViewCreated( View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.btn_insert_task);


        date=(EditText) view.findViewById(R.id.insert_et_date);
        title=(EditText) view.findViewById(R.id.insert_et_title);
        time=(EditText) view.findViewById(R.id.insert_et_time);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        stringDate= (String) date.getText().toString();
        stringTime=(String) time.getText().toString();
        stringTitle=(String) title.getText().toString();

        Task task=new Task(stringTitle,stringDate,stringTime);
      TasksDatabase.getInstance(requireContext()).tasksDao().addTask(task);

        dismiss();
    }
});



    }
}