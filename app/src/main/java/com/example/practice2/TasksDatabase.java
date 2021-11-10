package com.example.practice2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Task.class}, version = 1, exportSchema = false)
public  abstract class TasksDatabase extends RoomDatabase {

    private static TasksDatabase instance;

    public static TasksDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,TasksDatabase.class ,"TasksDatabase")
                           .allowMainThreadQueries()
                    .build();

        }
        return instance;


    }

public abstract TasksDao tasksDao();
}
