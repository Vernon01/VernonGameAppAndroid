package com.example.vernon.vernongameapplication.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vernon.vernongameapplication.R;

import Model.Games;

/**
 * Created by VERNON on 2016/09/01.
 */
public class GameListAdapter extends ArrayAdapter<Games> {

    private Games[] values;
    public GameListAdapter(Context context, int resource, Games[] values) {
        super(context, resource, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.game_list_row, null);
        }

        TextView gameTitle = (TextView) view.findViewById(R.id.game_title);
        TextView gameYear = (TextView) view.findViewById(R.id.game_year);
        TextView gameCategory = (TextView) view.findViewById(R.id.game_category);
        gameTitle.setText(values[position].getTitle());
        gameYear.setText(values[position].getYear());
        gameCategory.setText(values[position].getCategory());
        return view;

    }
}
