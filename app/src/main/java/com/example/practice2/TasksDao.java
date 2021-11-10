package com.example.practice2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TasksDao {
    @Insert
    void addTask(Task task);
    @Delete
    void deleteTask(Task task);
    @Update
    void editTask(Task task);

    @Query("Select* From taskstable Where status='done'")
    List<Task> getDoneTasks();

    @Query("Select* From taskstable Where status='active'")
        List<Task>getActiveTasks();

    @Query("Select* From taskstable Where status='archive'")
        List<Task>getArchiveTasks();

    @Query("Select* From taskstable")
        List<Task>getTasks();
@Query("Delete From taskstable" )
    void deleteAll();
}
