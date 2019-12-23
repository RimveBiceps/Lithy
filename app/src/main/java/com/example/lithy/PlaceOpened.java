package com.example.lithy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlaceOpened extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_opened);

        if(getIntent().hasExtra("pasirinkimas")) {
            Place place = getIntent().getParcelableExtra("pasirinkimas");

            assert place != null;
            String line1 = place.getName();
            String line2 = place.getPlace();
            String line3 = place.getDescription();
            String line4 = place.getWeb();
            String line5 = place.getGps();
            String line6 = place.getImg();

            TextView textView1 = findViewById(R.id.name1);
            textView1.setText(line1);

            TextView textView2 = findViewById(R.id.location1);
            textView2.setText(line2);

            TextView textView3 = findViewById(R.id.description1);
            textView3.setText(line3);

            TextView textView4 = findViewById(R.id.web1);
            textView4.setText(line4);

            TextView textView5 = findViewById(R.id.gps1);
            textView5.setText(line5);

            ImageView imgView6 = findViewById(R.id.img1);

            /*
            .fit().centerCrop() it makes all images same size
            fit - wait until the ImageView has been measured and resize the image to exactly match its size.
            centerCrop - scale the image honoring the aspect ratio until it fills the size. Crop either the top and bottom or left and right so it matches the size exactly.
             */
            Picasso.get().load(line6).fit().centerCrop().into(imgView6);

        }
    }
}
