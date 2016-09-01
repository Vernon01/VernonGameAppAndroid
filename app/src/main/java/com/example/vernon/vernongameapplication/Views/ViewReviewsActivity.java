package com.example.vernon.vernongameapplication.Views;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vernon.vernongameapplication.MainActivity;
import com.example.vernon.vernongameapplication.R;
import com.example.vernon.vernongameapplication.Repositories.Rest.RestGameApi;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import Model.Games;

/**
 * Created by VERNON on 2016/08/31.
 */
public class ViewReviewsActivity extends Activity {

    private RestGameApi restSubjectAPI = new RestGameApi();
    TextView title;
    EditText inputYear;
    EditText inputCategory;
    Button editGame;
    Button deleteGame;
    long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_reviews);
        title = (TextView)findViewById(R.id.view_game_title);
        inputYear = (EditText) findViewById(R.id.view_input_game_year);
        inputCategory = (EditText) findViewById(R.id.view_input_game_category);


        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {

            id = bundle.getLong("id");
            title.setText(bundle.getString("title"));
            inputYear.setText(bundle.getString("year"));
            inputCategory.setText(bundle.getString("category"));
        }


        editGame = (Button) findViewById(R.id.edit_button);
        deleteGame = (Button) findViewById(R.id.delete_button);
//        editSubject.setEnabled(false);
//        deleteSubject.setEnabled(false);


        editGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new editSubject().execute();
                Intent viewSubjects = new Intent(ViewReviewsActivity.this, GameListActivity.class);
                startActivity(viewSubjects);
            }
        });

        deleteGame.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new deleteSubject();
                Intent viewSubjects = new Intent(ViewReviewsActivity.this, GameListActivity.class);
                startActivity(viewSubjects);

            }
        });


    }



    private class editSubject extends AsyncTask<Void, Void, Void> {

        public Games CreateSubject() {
            Games newSubject = new Games();
            long subjectId = id;
            String title1 = title.getText().toString();
            String year = inputYear.getText().toString();
            String category = inputCategory.getText().toString();
            newSubject.setId(id);
            newSubject.setTitle(title1);
            newSubject.setYear(year);
            newSubject.setCategory(category);
            return newSubject;
        }

        @Override
        protected Void doInBackground(Void... params) {
            Games sub = CreateSubject();
            restSubjectAPI.put(sub);
            return null;
        }


    }

    private class deleteSubject  {
        public Games CreateSubject() {
            Games newSubject = new Games();
            long subjectId = id;
            String title1 = title.getText().toString();
            String year = inputYear.getText().toString();
            String category = inputCategory.getText().toString();
            newSubject.setId(subjectId);
            newSubject.setTitle(title1);
            newSubject.setYear(year);
            newSubject.setCategory(category);


            Games sub = CreateSubject();
            restSubjectAPI.delete(sub);
            return newSubject;
        }
    }
}
