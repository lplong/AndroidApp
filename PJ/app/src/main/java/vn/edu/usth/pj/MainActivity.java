package vn.edu.usth.pj;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//831ec66c83c84a2792b943a37e1e3e56
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatAct;
//    private View_Page view_page;
//    private ArrayList<Articles> articlesArrayList;
//    private View view_new;
//    private RecyclerView rview;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rview = findViewById(R.id.news_ap);
//        articlesArrayList = new ArrayList<>();
//        view_page = new View_Page(articlesArrayList, this);
//        rview.setLayoutManager(new LinearLayoutManager(this));
//        rview.setAdapter(view_page);
        //getNews();

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);

        bottomNavigationView.setBackground(null);

        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new Home()).commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;

                switch (item.getItemId())
                {
                    case R.id.home : temp = new Home();
                        break;
                    case R.id.search : temp = new Search();
                        break;

                    case R.id.history : temp = new History();
                        break;

                    case R.id.setting :
                         Intent pref = new Intent(getApplicationContext(),SettingsActivity.class);
                         startActivity(pref);
                         finish();
                         break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                return true;
            }
        });

        floatAct = (FloatingActionButton) findViewById(R.id.person);
        floatAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new Account()).commit();
            }
        });

    }
//    private void getNews(){
//        articlesArrayList.clear();
//        String url = "https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=831ec66c83c84a2792b943a37e1e3e56";
//        String base_url = "https://newsapi.org/";
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
//        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//        Call<NewsModel> call;
//        call = retrofitAPI.getAllNews(url);
//
//        call.enqueue(new Callback<NewsModel>() {
//            @Override
//            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
//                NewsModel newsModel = response.body();
//                ArrayList<Articles> articles = newsModel.getArticles();
//                for (int i=0; i<articles.size(); i++){
//                    articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrlToImage(),
//                            articles.get(i).getUrl(), articles.get(i).getContent()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsModel> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}