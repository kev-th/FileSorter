import java.io.File;
import java.util.Scanner;

/**
 * Created by kevinthaw on 7/27/17.
 */

class FileSorter {
    private static String filePath = null;
    private static String destination = null;
    private static String docsDestination;
    private static String musicsDestination;
    private static String videosDestination;
    private static String miscDestination;
    private static String picturesDestination;


    private static void makeSortedFolders() {
        docsDestination = destination + "/Documents/";
        new File(docsDestination).mkdirs();

        musicsDestination = destination + "/Musics/";
        new File(musicsDestination).mkdirs();

        videosDestination = destination + "/Videos/";
        new File(videosDestination).mkdirs();

        miscDestination = destination + "/Misc/";
        new File(miscDestination).mkdirs();

        picturesDestination = destination + "/Pics/";
        new File(picturesDestination).mkdirs();

    }

    private static void sortFiles(File[] filesNames) {

        for (int i = 0; i < filesNames.length; i++) {
            if (filesNames[i].isFile()) {

                if (filesNames[i].getName().endsWith(".rtf") || filesNames[i].getName().endsWith(".doc") || filesNames[i].getName().endsWith(".docx") || filesNames[i].getName().endsWith(".pdf")) {

                    filesNames[i].renameTo(new File(docsDestination + filesNames[i].getName()));
                    filesNames[i].delete();
                } else if (filesNames[i].getName().endsWith(".jpg") || filesNames[i].getName().endsWith(".jpeg") || filesNames[i].getName().endsWith(".gif") || filesNames[i].getName().endsWith(".png") || filesNames[i].getName().endsWith(".tiff")) {

                    filesNames[i].renameTo(new File(picturesDestination + filesNames[i].getName()));
                    filesNames[i].delete();
                } else if (filesNames[i].getName().endsWith(".mp3") || filesNames[i].getName().endsWith(".wav") || filesNames[i].getName().endsWith(".m4a") || filesNames[i].getName().endsWith(".flac") || filesNames[i].getName().endsWith(".aac")) {

                    filesNames[i].renameTo(new File(musicsDestination + filesNames[i].getName()));
                    filesNames[i].delete();
                } else if (filesNames[i].getName().endsWith(".mp4") || filesNames[i].getName().endsWith(".avi") || filesNames[i].getName().endsWith(".mov") || filesNames[i].getName().endsWith(".flv") || filesNames[i].getName().endsWith(".wmv")) {

                    filesNames[i].renameTo(new File(videosDestination + filesNames[i].getName()));
                    filesNames[i].delete();
                } else {
                    filesNames[i].renameTo(new File(miscDestination + filesNames[i].getName()));
                    filesNames[i].delete();
                }

            }

            if (filesNames[i].isDirectory()) {
                makeFilesList(filesNames[i]);
            }
        }

    }


    private static void makeFilesList(File dir) {
        File[] filesList = dir.listFiles();
        sortFiles(filesList);

    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the path of the folder to sort: ");
        filePath = keyboard.nextLine();
        System.out.println("Enter the path for the sorted files: ");
        destination = keyboard.nextLine();

        File folder = new File(filePath);
        makeSortedFolders();

        makeFilesList(folder);

    }
}

