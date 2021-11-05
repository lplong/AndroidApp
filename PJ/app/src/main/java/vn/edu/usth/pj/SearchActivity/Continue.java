package vn.edu.usth.pj.SearchActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {
    @SerializedName("gsroffset")
    @Expose
    private Integer gsroffset;
    @SerializedName("continue")
    @Expose
    private String _continue;

    public Integer getGsroffset() {
        return gsroffset;
    }

    public void setGsroffset(Integer gsroffset) {
        this.gsroffset = gsroffset;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }
}
