package com.example.studymore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studymore.ui.Activity.ActivityAdapter;
import com.example.studymore.ui.Activity.ActivityDatabase;
import com.example.studymore.ui.Quiz.QuizResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ImageButton settingsButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    //to create score recording
    public static ArrayList<QuizResult> quizResultArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizResultArrayList = new ArrayList<QuizResult>();

        //set the settings button
        settingsButton = findViewById(R.id.settingsClog);

        //onClick Listener for settings button
        //onClickListener to get new Fact
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                Intent intentBtn = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intentBtn);
            }
        });

        recyclerView = findViewById(R.id.rv_activity);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter();

        activityAdapter.setData(ActivityDatabase.getAllActivity());
        recyclerView.setAdapter(activityAdapter);


    }
}
