package vn.edu.usth.pj.Article_Activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article_FM {
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
