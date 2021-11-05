package vn.edu.usth.pj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import vn.edu.usth.pj.search.Example;
import vn.edu.usth.pj.search.Page;
import vn.edu.usth.pj.search.Query;

public interface RetrofitAPI {
    @GET(API_CER.API + "action=parse&prop=text&mobileformat=1&page=Main_Page")
    Call<Articles> getArticles();

    @GET (API_CER.API + "action=query&converttitles=&prop=description|pageimages|pageprops|info&ppprop=mainpage|disambiguation&generator=search&gsrnamespace=0&gsrwhat=text&inprop=varianttitles&gsrinfo=&gsrprop=redirecttitle&piprop=thumbnail&pilicense=any&pithumbsize=320")
    Call<Example> getQuery(@retrofit2.http.Query("gsrsearch") String gsrsearch);


}
