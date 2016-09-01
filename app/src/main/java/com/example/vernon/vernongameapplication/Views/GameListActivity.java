package com.example.vernon.vernongameapplication.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vernon.vernongameapplication.R;
import com.example.vernon.vernongameapplication.Repositories.Rest.RestGameApi;
import com.example.vernon.vernongameapplication.Views.Adapters.GameListAdapter;

import java.util.ArrayList;
import java.util.List;

import Model.Games;

/**
 * Created by VERNON on 2016/09/01.
 */
public class GameListActivity extends Activity {

    private RestGameApi restSubjectAPI = new RestGameApi();
    List<Games> subjectList = new ArrayList<Games>();
    ListView subjectsList;
    GameListAdapter adapter ;
    Games[] subjectsl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list);
        subjectsList = (ListView) findViewById(R.id.game_list);
        new GetSubjectsTask().execute();

        subjectsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games subject = adapter.getItem(position);
                Intent editAndDeleteIntent = new Intent(GameListActivity.this, ViewReviewsActivity.class);
                editAndDeleteIntent.putExtra("id", subject.getId());
                editAndDeleteIntent.putExtra("title", subject.getTitle());
                editAndDeleteIntent.putExtra("year", subject.getYear());
                editAndDeleteIntent.putExtra("category", subject.getCategory());
                startActivity(editAndDeleteIntent);
            }
        });
    }


    class GetSubjectsTask extends AsyncTask<Void, Void, List<Games>> {
        List<Games> subjects = new ArrayList<Games>();

        protected List<Games> doInBackground(Void... params) {
            subjects = restSubjectAPI.getAll();
            return subjects;
        }
        protected void onPostExecute( List<Games> subjects) {
            subjectList = subjects;
            subjectsl = subjectList.toArray(new Games[subjectList.size()]);
            adapter = new GameListAdapter(GameListActivity.this, R.id.game_list, subjectsl);
            subjectsList.setAdapter(adapter);

        }

    }
}
