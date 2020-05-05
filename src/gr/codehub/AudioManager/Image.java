package gr.codehub.AudioManager;

import java.util.Date;

public class Image extends Media{
    private String quality;

    public Image(int id, String filename, String filetype, String title, String description, String creator, float size, String quality) {
        super(id, filename, filetype, title, description, creator, size);
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Image{" +
                "quality='" + quality + '\'' +
                '}';
    }
}
