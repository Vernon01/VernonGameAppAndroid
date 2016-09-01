package com.example.vernon.vernongameapplication.Views;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vernon.vernongameapplication.R;
import com.example.vernon.vernongameapplication.Repositories.Rest.RestGameApi;

import Model.Games;

/**
 * Created by VERNON on 2016/09/01.
 */
public class AddReviewActivity extends Activity {

    private RestGameApi restSubjectAPI = new RestGameApi();
    EditText inputTitle;
    EditText inputYear;
    EditText inputCategory;
    Button saveSubject;
    Button clearFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review);
        inputTitle = (EditText) findViewById(R.id.input_game_title);
        inputYear = (EditText) findViewById(R.id.input_game_year);
        inputCategory = (EditText) findViewById(R.id.input_game_category);
        saveSubject = (Button) findViewById(R.id.save_button);
        clearFields = (Button) findViewById(R.id.button3);

        saveSubject.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new saveSubject().execute();
            }
        });

        clearFields.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inputTitle.setText("");
                inputCategory.setText("");
                inputYear.setText("");
            }
        });


    }

    private class saveSubject extends AsyncTask<Void, Void, Void> {

        public Games CreateSubject() {
            Games newSubject = new Games();
            String title = inputTitle.getText().toString();
            String year = inputYear.getText().toString();
            String category = inputCategory.getText().toString();
            newSubject.setTitle(title);
            newSubject.setYear(year);
            newSubject.setCategory(category);
            return newSubject;

        }


        @Override
        protected Void doInBackground(Void ... params) {
            Games sub;

            try{
                sub = CreateSubject();
                restSubjectAPI.post(sub);



            } catch (Exception e) {
                Log.e("log_tag", "Error:  " + e.toString());
            }

            return null;
        }


    }


}
