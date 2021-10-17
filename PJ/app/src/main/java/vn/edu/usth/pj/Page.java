package vn.edu.usth.pj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Page extends AppCompatActivity {
    String title, desc, content;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_page);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        image = getIntent().getIntExtra("image", R.drawable.r6);
        content = getIntent().getStringExtra("content");
        setPageContent(title, desc, image, content);

    }

    private void setPageContent(String title, String desc, int image, String content) {
        TextView titleC = findViewById(R.id.textView);
        titleC.setText(title);

        TextView descC = findViewById(R.id.textView2);
        descC.setText(desc);

        ImageView img = findViewById(R.id.imageView2);
        img.setImageResource(image);

        TextView cont = findViewById(R.id.textView3);
        cont.setText(content);
    }



}