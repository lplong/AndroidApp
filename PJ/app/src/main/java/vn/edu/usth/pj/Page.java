package vn.edu.usth.pj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Page extends AppCompatActivity {
    String title, desc, content, imageURL, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("imageURL");
        url = getIntent().getStringExtra("url");
    }
}