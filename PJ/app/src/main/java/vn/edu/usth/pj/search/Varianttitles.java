package vn.edu.usth.pj.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Varianttitles {
    @SerializedName("en")
    @Expose
    private String en;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
