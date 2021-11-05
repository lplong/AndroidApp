package vn.edu.usth.pj.SearchActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pageprops {
    @SerializedName("disambiguation")
    @Expose
    private String disambiguation;

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }
}
