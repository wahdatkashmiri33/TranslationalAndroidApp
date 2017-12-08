/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.emzah.kasher.zabaan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
TextView numbers=(TextView)findViewById(R.id.numbers);



        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent);
            }
        });

        TextView colors=(TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsIntent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });
        TextView vegetables=(TextView)findViewById(R.id.vegetables);
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vegetablesIntent=new Intent(MainActivity.this,Vegetables.class);
                startActivity(vegetablesIntent);
            }
        });
        TextView family=(TextView)findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        TextView fruits=(TextView)findViewById(R.id.fruits);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruitsIntent= new Intent(MainActivity.this,FruitsActivity.class);
                startActivity(fruitsIntent);
            }
        });
        TextView animals=(TextView)findViewById(R.id.animals);
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AnimalsIntent= new Intent(MainActivity.this,Animals.class);
                startActivity(AnimalsIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this );
        builder.setMessage("Do you really want to exit the App?");
        builder.setCancelable(true);


        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
