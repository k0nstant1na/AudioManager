package gr.codehub.AudioManager;

import java.util.Date;
import java.util.Scanner;

public class UI {

    public ChoiceMediaFile menu() {
        ChoiceMediaFile returnChoice;
        System.out.println("1. Add a Media File   2. Remove a Media File" +
                "    3. Display Media Files     4.  Clear basket  5. Save to file 6. Load from file 7. Search by filename 8. Search by index 9. Get total records 10. Get total size 0. Exit" +
                "");

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return ChoiceMediaFile.ADD;
                case 2:
                    return ChoiceMediaFile.REMOVE;
                case 3:
                    return ChoiceMediaFile.DISPLAY;
                case 4:
                    return ChoiceMediaFile.CLEAR;
                case 5:
                    return ChoiceMediaFile.SAVE;
                case 6:
                    return ChoiceMediaFile.LOAD;
                case 7:
                    return ChoiceMediaFile.SEARCHBYFILENAME;
                case 8:
                    return ChoiceMediaFile.SEARCHBYINDEX;
                case 9:
                    return ChoiceMediaFile.GETTOTALRECORDS;
                case 10:
                    return ChoiceMediaFile.GETTOTALSIZE;
                case 0:
                    return ChoiceMediaFile.EXIT;
                default:
                    return ChoiceMediaFile.ERROR;
            }
        } catch (Exception e) {
            return ChoiceMediaFile.ERROR;
        }

    }

    //factory method design pattern
    public Media createMediaFile() {
        int id;
        String filename;
        String filetype;
        String title;
        String description;
        String creator;
        float size;
        int typeofFile;
        Media MediaFile;
        String singer;
        String quality;
        String duration;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Audio File 2. Image File 3. Video File");
        typeofFile = scanner.nextInt();

        System.out.println("Give the file id ");
        id = scanner.nextInt();
        System.out.println("Give the file name ");
        filename = scanner.next();
        System.out.println("Give the file type ");
        filetype = scanner.next();
        System.out.println("Give the file title ");
        title = scanner.next();
        System.out.println("Give the file description ");
        description = scanner.next();
        System.out.println("Give the file creator ");
        creator = scanner.next();
        System.out.println("Give the file size ");
        size = scanner.nextFloat();

        switch (typeofFile) {
            case 1:
                System.out.println("Give singer");
                singer = scanner.next();
                MediaFile = new Audio(id, filename, filetype, title, description, creator, size, singer);
                return MediaFile;
            case 2:
                System.out.println("Give quality");
                quality = scanner.next();
                MediaFile = new Image(id, filename, filetype, title, description, creator, size, quality);
                return MediaFile;
            case 3:
                System.out.println("Give duration");
                duration = scanner.next();
                MediaFile = new Video(id, filename, filetype, title, description, creator, size, duration);
                return MediaFile;
            default:
                return null;
        }

    }

//
    public void manageMediaList(MediaFilesList mediafiles) {
        ChoiceMediaFile choice;
        String filename;
        do {
            choice = menu();

            switch (choice) {
                case ADD:
                    Media mediaFile = createMediaFile();
                    mediafiles.addMediaFile(mediaFile);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    mediafiles.removeMediaFile(index);
                    break;
                case DISPLAY:
                    mediafiles.displayMediaFileList();
                    break;
                case CLEAR:
                    mediafiles.clearMediaFileList();
                    break;
                case SAVE:
                    mediafiles.saveMediaFileList("MediaList.txt");
                    break;
                case LOAD:
                    mediafiles.loadMediaFilesList("MediaList.txt");
                    break;
                case SEARCHBYFILENAME:
                    scanner = new Scanner(System.in);
                    System.out.println("Type the filename:");
                    String input_name = scanner.next();
                    MediaFilesList searchfile = mediafiles.searchfile(input_name);
                    if (searchfile == null)
                        System.out.println("No file found!");
                    else
                        searchfile.displayMediaFileList();
                    break;
                case SEARCHBYINDEX:
                    scanner = new Scanner(System.in);
                    System.out.println("Give an index:");
                    int search_index = scanner.nextInt();
                    MediaFilesList search_file = mediafiles.searchindex(search_index);
                    if (search_file == null)
                        System.out.println("No file found!");
                    else
                        search_file.displayMediaFileList();
                    break;
                case GETTOTALRECORDS:
                    mediafiles.totalrecords();
                    break;
                case GETTOTALSIZE:
                    mediafiles.totalsize();
                    break;
                case EXIT:
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;

            }
        } while (choice != ChoiceMediaFile.EXIT);

    }


}

