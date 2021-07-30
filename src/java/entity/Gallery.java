package entity;

public class Gallery {

    private int id;
    private String name;
    private String description;
    private String image;

    public Gallery() {
    }

    public Gallery(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        if (description.length() > 200) {
            this.description = description.substring(0, 200) + "...";
        } else {
            this.description = description;
        }
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
