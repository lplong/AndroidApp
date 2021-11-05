package vn.edu.usth.pj.MainPage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.edu.usth.pj.MainPage.Parse;

public class Articles {
    @SerializedName("parse")
    @Expose
    private Parse parse;

    public Parse getParse() {
        return parse;
    }

    public void setParse(Parse parse) {
        this.parse = parse;
    }

}
