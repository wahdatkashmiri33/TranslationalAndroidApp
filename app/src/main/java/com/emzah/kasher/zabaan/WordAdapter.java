package com.emzah.kasher.zabaan;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WAHDAT KASHMIRI on 01-11-2017.
 */

public class WordAdapter extends ArrayAdapter<word>{

    private int mColorResourceId;
public WordAdapter(Activity context, ArrayList<word> words, int ColorResourceId){
    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    super(context,0,words);
    mColorResourceId= ColorResourceId;
}

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID kash_text_view
        TextView kashTextView = (TextView) listItemView.findViewById(R.id.kash_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        kashTextView.setText(currentword.getMkashurTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentword.getMdefaultTranslation());


        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        if (currentword.hasImage()){
            imageView.setImageResource(currentword.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
       else {
          imageView.setVisibility(View.GONE);
        }


        //set the theme color for the resource item
        View textContainer=listItemView.findViewById(R.id.text_container);
       //find the color resource id maps to
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        //set the text container of resource background color to
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
