package gr.codehub.AudioManager;

import java.util.Date;

public class Video extends Media{
    private String duration;

    public Video(int id, String filename, String filetype, String title, String description, String creator, float size, String duration) {
        super(id, filename, filetype, title, description, creator, size);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Video{" +
                "duration='" + duration + '\'' +
                '}';
    }
}
