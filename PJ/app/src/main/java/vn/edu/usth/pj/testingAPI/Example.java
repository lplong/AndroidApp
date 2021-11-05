package vn.edu.usth.pj.testingAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("lead")
    @Expose
    private Lead lead;
    @SerializedName("remaining")
    @Expose
    private Remaining remaining;

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public Remaining getRemaining() {
        return remaining;
    }

    public void setRemaining(Remaining remaining) {
        this.remaining = remaining;
    }
}
