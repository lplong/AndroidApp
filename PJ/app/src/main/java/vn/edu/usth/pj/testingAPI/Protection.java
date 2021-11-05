package vn.edu.usth.pj.testingAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Protection {
    @SerializedName("edit")
    @Expose
    private List<String> edit = null;
    @SerializedName("move")
    @Expose
    private List<String> move = null;

    public List<String> getEdit() {
        return edit;
    }

    public void setEdit(List<String> edit) {
        this.edit = edit;
    }

    public List<String> getMove() {
        return move;
    }

    public void setMove(List<String> move) {
        this.move = move;
    }
}
