package vn.edu.usth.pj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView rview;
    private View_Page view_page;
    SearchView searchView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

//        rview = (RecyclerView) rootView.findViewById(R.id.news_ap);
//        searchView = (SearchView) rootView.findViewById(R.id.searchview_home);
//        rview.setLayoutManager(new LinearLayoutManager(getContext()));
//        view_page = new View_Page(getArticle(), getContext());
//        rview.setAdapter(view_page);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                view_page.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                view_page.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return rootView;
//
//    }
//
//    private List<Articles> getArticle() {
//        List<Articles> list = new ArrayList<>();
//        return list;
//    }

        TextView textV = (TextView) rootView.findViewById(R.id.news_ap);

        RetrofitAPI wikiApi = Service.createService(RetrofitAPI.class);

        Call<Articles> call = wikiApi.getArticles();

        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "404", Toast.LENGTH_SHORT).show();
                    return;
                }
                Articles main = response.body();

                textV.setText(Html.fromHtml(main.getParse().getText()));
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }
}