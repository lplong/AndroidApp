package vn.edu.usth.pj.testingAPI;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Lead {
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("revision")
    @Expose
    private Integer revision;
    @SerializedName("lastmodified")
    @Expose
    private String lastmodified;
    @SerializedName("lastmodifier")
    @Expose
    private Lastmodifier lastmodifier;
    @SerializedName("displaytitle")
    @Expose
    private String displaytitle;
    @SerializedName("normalizedtitle")
    @Expose
    private String normalizedtitle;
    @SerializedName("wikibase_item")
    @Expose
    private String wikibaseItem;
    @SerializedName("protection")
    @Expose
    private Protection protection;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("mainpage")
    @Expose
    private Boolean mainpage;
    @SerializedName("languagecount")
    @Expose
    private Integer languagecount;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(String lastmodified) {
        this.lastmodified = lastmodified;
    }

    public Lastmodifier getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(Lastmodifier lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    public String getDisplaytitle() {
        return displaytitle;
    }

    public void setDisplaytitle(String displaytitle) {
        this.displaytitle = displaytitle;
    }

    public String getNormalizedtitle() {
        return normalizedtitle;
    }

    public void setNormalizedtitle(String normalizedtitle) {
        this.normalizedtitle = normalizedtitle;
    }

    public String getWikibaseItem() {
        return wikibaseItem;
    }

    public void setWikibaseItem(String wikibaseItem) {
        this.wikibaseItem = wikibaseItem;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getMainpage() {
        return mainpage;
    }

    public void setMainpage(Boolean mainpage) {
        this.mainpage = mainpage;
    }

    public Integer getLanguagecount() {
        return languagecount;
    }

    public void setLanguagecount(Integer languagecount) {
        this.languagecount = languagecount;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
