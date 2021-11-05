package vn.edu.usth.pj.testingAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {
    @SerializedName("320")
    @Expose
    private String _320;
    @SerializedName("640")
    @Expose
    private String _640;
    @SerializedName("800")
    @Expose
    private String _800;
    @SerializedName("1024")
    @Expose
    private String _1024;

    public String get320() {
        return _320;
    }

    public void set320(String _320) {
        this._320 = _320;
    }

    public String get640() {
        return _640;
    }

    public void set640(String _640) {
        this._640 = _640;
    }

    public String get800() {
        return _800;
    }

    public void set800(String _800) {
        this._800 = _800;
    }

    public String get1024() {
        return _1024;
    }

    public void set1024(String _1024) {
        this._1024 = _1024;
    }
}
