package com.example.practice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
List<Task> task;
boolean flag1,flag2;
    public TaskAdapter(List<Task> task,boolean flag1,boolean flag2) {
        this.task = task;
        this.flag1=flag1;
        this.flag2=flag2;
    }


    @Override
    public TaskHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
TaskHolder taskHolder=new TaskHolder(view);
        return taskHolder;
    }

    @Override
    public void onBindViewHolder( TaskAdapter.TaskHolder holder, int position) {
    Task currTask= task.get(position);
        holder.title.setText(currTask.getTitle());
        holder.date.setText("Date :"+currTask.getDate());
        holder.time.setText("Time :"+currTask.getTime());
        holder.imageViewDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(flag1==true){
                currTask.setStatus("done");
                TasksDatabase.getInstance(view.getContext()).tasksDao().editTask(currTask);
                task.remove(position);
                notifyItemRemoved(position);
              }

            }
        });
                 holder.imageViewArchive.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         if(flag2==true) {
                             currTask.setStatus("archive");
                             TasksDatabase.getInstance(view.getContext()).tasksDao().editTask(currTask);
                             task.remove(position);
                             notifyItemRemoved(position);
                         }
                     }
                 });
    }

    @Override
    public int getItemCount() {
        return task.size();
    }


    class TaskHolder extends RecyclerView.ViewHolder {
        TextView title,date,time;
        ImageView imageViewDone, imageViewArchive;

        public TaskHolder(View itemView) {
            super(itemView);
            imageViewDone = itemView.findViewById(R.id.done);
            imageViewArchive = itemView.findViewById(R.id.archive);
            title=itemView.findViewById(R.id.task_title);
            date=itemView.findViewById(R.id.task_date);
            time=itemView.findViewById(R.id.task_time);

        }


    }

}
