package com.example.practice2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "taskstable")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id=0;
    @ColumnInfo(name = "titleColumn")
    public String title;
    @ColumnInfo(name = "dateColumn")
    public  String date;
    @ColumnInfo(name = "timeColumn")
    public  String time;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @ColumnInfo(name = "status")
    public String status="active";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }
    public Task() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
