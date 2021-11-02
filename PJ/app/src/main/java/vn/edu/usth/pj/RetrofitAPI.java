package vn.edu.usth.pj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET(API_CER.API + "page=Main_Page")
    Call<Articles> getArticles();


}
