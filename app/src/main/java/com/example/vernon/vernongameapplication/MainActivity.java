package com.example.vernon.vernongameapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.vernon.vernongameapplication.Views.AddReviewActivity;
import com.example.vernon.vernongameapplication.Views.GameListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addReviewButton  = (Button) findViewById(R.id.button);
        Button viewReviewsButton = (Button) findViewById(R.id.button2);



        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSubject = new Intent(MainActivity.this, AddReviewActivity.class);
                startActivity(addSubject);
            }
        });

        viewReviewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSubjects = new Intent(MainActivity.this, GameListActivity.class);
                startActivity(viewSubjects);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.game_title) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
