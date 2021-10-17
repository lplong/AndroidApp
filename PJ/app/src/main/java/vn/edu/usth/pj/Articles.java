package vn.edu.usth.pj;

public class Articles {
    private String title;
    private String description;
    private int image;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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


    public Articles(String title, String description, int image, String content) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.content = content;
    }
}
