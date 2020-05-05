package gr.codehub.AudioManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaFilesList {
    private ArrayList<Media> mediaFileList = new ArrayList<>();

    public void addMediaFile(Media mediafile) {
        mediaFileList.add(mediafile);
    }

    public void displayMediaFileList() {
        if (mediaFileList.isEmpty()) {
            System.out.println("No records!");
        }
        else {
            for (Media mediafile : mediaFileList) {
                System.out.println(mediafile);
            }
        }
    }

    public void removeMediaFile(int index) {
        if (mediaFileList.isEmpty())
            System.out.println("No records!");
        else if (index >= 0 && index < mediaFileList.size()) {
            mediaFileList.remove(index);
        }
        else
            System.out.println("This record does not exist!");
    }

    public void clearMediaFileList() {
        mediaFileList.clear();
    }

    public void saveMediaFileList(String fileName) {
        //int typefile = Integer.parseInt(filetype);

        try {
            PrintWriter printWriter = new PrintWriter(new File(fileName));
            for (var mediaFile : mediaFileList){
                if (mediaFile.getClass() == Video.class) {
                    Video f = (Video)mediaFile;
                    String text = f.getId() + "," + f.getFilename() + "," + f.getFiletype() + ","
                            + f.getTitle() + "," + f.getDescription() + "," + f.getCreator() + ","
                            + "," + f.getSize() + "," + f.getDuration();
                    printWriter.println(text);
                }
                else if (mediaFile.getClass() == Audio.class) {
                    Audio f = (Audio)mediaFile;
                    String text = f.getId() + "," + f.getFilename() + "," + f.getFiletype() + ","
                            + f.getTitle() + "," + f.getDescription() + "," + f.getCreator() + ","
                            + "," + f.getSize() + "," + f.getSinger();
                    printWriter.println(text);
                }
                else if (mediaFile.getClass() == Image.class) {
                    Image f = (Image) mediaFile;
                    String text = f.getId() + "," + f.getFilename() + "," + f.getFiletype() + ","
                            + f.getTitle() + "," + f.getDescription() + "," + f.getCreator() + ","
                            + "," + f.getSize() + "," + f.getQuality();
                    printWriter.println(text);
                }
            }
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }


    public void loadMediaFilesList(String fileName) {
        mediaFileList.clear();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                if (words[2].equalsIgnoreCase("video")) {
                    Video newVideoFile = new Video(Integer.parseInt(words[0]),words[1], words[2],words[3], words[4], words[5], Float.parseFloat(words[6]), words[7]);
                    mediaFileList.add(newVideoFile);
                } else if (words[2].equalsIgnoreCase("audio")) {
                    Audio newAudioFile = new Audio(Integer.parseInt(words[0]),words[1], words[2],words[3], words[4], words[5], Float.parseFloat(words[6]), words[7]);
                    mediaFileList.add(newAudioFile);
                } else if (words[2].equalsIgnoreCase("image")) {
                    Image newImageFile = new Image(Integer.parseInt(words[0]),words[1], words[2],words[3], words[4], words[5], Float.parseFloat(words[6]), words[7]);
                    mediaFileList.add(newImageFile);
                }
            }
        }
            catch (Exception e) {
        }
    }

    public MediaFilesList searchfile(String fileName){
        MediaFilesList searchlist = new MediaFilesList();
        mediaFileList.forEach(mediaFile -> {
            if (mediaFile.getFilename().equalsIgnoreCase(fileName)) {
                searchlist.addMediaFile(mediaFile);
            }
        });
        return searchlist;
    }

    public MediaFilesList searchindex(int index){
        MediaFilesList searchlist = new MediaFilesList();
        mediaFileList.forEach(mediaFile -> {
            if (mediaFile.getId() == index) {
                searchlist.addMediaFile(mediaFile);
            }
        });
        return searchlist;
    }

    public int totalrecords() {
        return mediaFileList.size();
    }

    public float totalsize() {
        return mediaFileList.stream().map(mediaFile -> mediaFile.getSize()).reduce(0.0f,(a,b) -> a+b);
    }
}

