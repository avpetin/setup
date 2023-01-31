import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dirListMain = new ArrayList<>();
        dirListMain.add("D:/Games/src");
        dirListMain.add("D:/Games/res");
        dirListMain.add("D:/Games/savegames");
        dirListMain.add("D:/Games/temp");

        List<String> dirListSrc = new ArrayList<>();
        dirListSrc.add("main");
        dirListSrc.add("test");

        List<String> dirListRes = new ArrayList<>();
        dirListRes.add("drawables");
        dirListRes.add("vectors");
        dirListRes.add("icons");

        List<String> fileListMain = new ArrayList<>();
        fileListMain.add("Main.java");
        fileListMain.add("Utils.java");

        List<String> fileListTemp = new ArrayList<>();
        fileListTemp.add("temp.txt");

        StringBuilder log = new StringBuilder();
        log.append(createDirectories(dirListMain));
        log.append(createDirectories(dirListSrc));
        log.append(createDirectories(dirListRes));
        log.append(createFiles("D:/Games/src/main", fileListMain));
        log.append(createFiles("D:/Games/temp", fileListTemp));

        writeLogToFile("D:/Games/temp/temp.txt", log);
    }

    public static StringBuilder createDirectories(List<String> dirList){
        StringBuilder log = new StringBuilder();
        for(String dir : dirList){
            File dirToCreate = new File(dir);
            if(dirToCreate.mkdir()){
                log.append("Каталог " + dirToCreate.getPath() + " создан\n");
            }
        }
        return log;
    }

    public static StringBuilder createFiles(String dir, List<String> fileList){
        StringBuilder log = new StringBuilder();
        for(String fileName : fileList){
            File fileTemp = new File(dir + fileName);
            try{
                if(fileTemp.createNewFile()){
                    log.append("Файл " + fileTemp.getPath() + " создан\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return log;
    }

    public static void writeLogToFile(String fileName, StringBuilder log){
        File fileTemp = new File(fileName);
        try(FileWriter fr = new FileWriter(fileTemp.getPath(), true)) {
            fr.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}