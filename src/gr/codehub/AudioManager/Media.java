package gr.codehub.AudioManager;

import java.util.Date;

public abstract class Media {
    private int id;
    private String filename;
    private String filetype;
    private String title;
    private String description;
    private String creator;
    private float size;

    public Media(int id, String filename, String filetype, String title, String description, String creator, float size) {
        this.id = id;
        this.filename = filename;
        this.filetype = filetype;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filetype='" + filetype + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
