package com.example.pluraltasks;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class TaskListActivity extends AppCompatActivity {

    private TextView taskItem;
    private View taskSeparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskItem = (TextView)findViewById(R.id.task_item);
        taskSeparator = (View)findViewById(R.id.task_separator);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCreateTask();
            }
        });
    }

    void showCreateTask() {
        Intent createTaskIntent = new Intent(this, CreateTaskActivity.class);
        startActivityForResult(createTaskIntent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }

        if (requestCode == 2) {
            String task=data.getStringExtra("TASK");
            taskItem.setText(task);
            taskItem.setVisibility(View.VISIBLE);
            taskSeparator.setVisibility(View.VISIBLE);
        }
    }
}
