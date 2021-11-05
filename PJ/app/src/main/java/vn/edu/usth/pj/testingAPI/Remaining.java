package vn.edu.usth.pj.testingAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Remaining {
    @SerializedName("sections")
    @Expose
    private List<Object> sections = null;

    public List<Object> getSections() {
        return sections;
    }

    public void setSections(List<Object> sections) {
        this.sections = sections;
    }
}
