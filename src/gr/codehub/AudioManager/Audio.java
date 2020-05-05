package gr.codehub.AudioManager;

import java.util.Date;

public class Audio extends Media{
    private String singer;

    public Audio(int id, String filename, String filetype, String title, String description, String creator, float size, String singer) {
        super(id, filename, filetype, title, description, creator, size);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Audio{" +
                "Singer='" + singer + '\'' +
                '}';
    }
}
