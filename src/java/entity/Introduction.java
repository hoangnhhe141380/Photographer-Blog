package entity;

public class Introduction {

    private String image;
    private String entry;
    private String aboutme;

    public Introduction() {
    }

    public Introduction(String image, String entry, String aboutme) {
        this.image = image;
        this.entry = entry;
        this.aboutme = aboutme;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

}
