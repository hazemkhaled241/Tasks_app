package com.example.practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.practice2.fragments.ArchiveFragment;
import com.example.practice2.fragments.DoneFragment;
import com.example.practice2.fragments.InsertTaskSheetFragment;
import com.example.practice2.fragments.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    List<Task> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TasksDatabase.getInstance(MainActivity.this).tasksDao().deleteAll();

        list=TasksDatabase.getInstance(MainActivity.this).tasksDao().getActiveTasks();
      showFragment(new TaskFragment(list));

      bottomNavigationView=findViewById(R.id.nav_bar);
      bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem item) {
             //bottomNavigationView.getMenu().findItem(item.getItemId()).setChecked(true);
             // item.setChecked(true);
              Fragment fragment=null;
              if(item.getItemId()==R.id.task_icon) {
                  list=TasksDatabase.getInstance(MainActivity.this).tasksDao().getActiveTasks();
                  fragment=new TaskFragment(list);

              }
            else if(item.getItemId()==R.id.done_icon){
                  list=TasksDatabase.getInstance(MainActivity.this).tasksDao().getDoneTasks();
                  fragment=new DoneFragment(list);
                   }
              else if(item.getItemId()==R.id.archive_icon){
                  list=TasksDatabase.getInstance(MainActivity.this).tasksDao().getArchiveTasks();
                  fragment=new ArchiveFragment(list);

              }

         return  showFragment(fragment);

          }
      });


/*InsertTask insertTask=new InsertTask() {
    @Override
    public void onTaskInserted() {

    }
};*/


    }

    private boolean showFragment(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame,f)
                .commit();
             return true;
    }

   public void insertTask(View view) {

        new InsertTaskSheetFragment().show(getSupportFragmentManager(), "insertSheet");

    }

}