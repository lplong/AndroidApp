package vn.edu.usth.pj;

public class Articles {
    private String title;
    private String description;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int image() {
        return image;
    }

    public void setImage(int Image) {
        this.image = image;
    }


    public Articles(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
