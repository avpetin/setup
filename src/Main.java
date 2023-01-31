import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File dirSrc = new File("D://Games/src");
        if (dirSrc.mkdir()) {
            log.append("Каталог " + dirSrc.getName() + " создан\n");
        }
        File dirRes = new File("D://Games/res");
        if (dirRes.mkdir()) {
            log.append("Каталог " + dirRes.getName() + " создан\n");
        }
        File dirSavegames = new File("D://Games/savegames");
        if (dirSavegames.mkdir()) {
            log.append("Каталог " + dirSavegames.getName() + " создан\n");
        }
        File dirTemp = new File("D://Games/temp");
        if (dirTemp.mkdir()) {
            log.append("Каталог " + dirTemp.getName() + " создан\n");
        }

        File dirMain = new File(dirSrc.getPath().concat("\\main"));
        if (dirMain.mkdir()) {
            log.append("Каталог " + dirMain.getName() + " создан\n");
        }
        File dirTest = new File(dirSrc.getPath().concat("\\test"));
        if (dirTest.mkdir()) {
            log.append("Каталог " + dirTest.getName() + " создан\n");
        }

        File fileMain = new File(dirMain.getPath().concat("\\Main.java"));
        try {
            if (fileMain.createNewFile()) {
                log.append("Файл " + fileMain.getName() + " создан\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        File fileUtils = new File(dirMain.getPath().concat("\\Utils.java"));
        try {
            if (fileUtils.createNewFile()) {
                log.append("Файл " + fileUtils.getName() + " создан\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File dirDrawables = new File(dirRes.getPath().concat("\\drawables"));
        if (dirDrawables.mkdir()) {
            log.append("Каталог " + dirDrawables.getName() + " создан\n");
        }
        File dirVectors = new File(dirRes.getPath().concat("\\vectors"));
        if (dirVectors.mkdir()) {
            log.append("Каталог " + dirVectors.getName() + " создан\n");
        }
        File dirIcons = new File(dirRes.getPath().concat("\\icons"));
        if (dirIcons.mkdir()) {
            log.append("Каталог " + dirIcons.getName() + " создан\n");
        }

        File fileTemp = new File(dirTemp.getPath().concat("\\temp.txt"));
        try {
            if (fileTemp.createNewFile()) {
                log.append("Файл " + fileTemp.getName() + " создан\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter fr = new FileWriter(fileTemp.getPath(), false)) {
            fr.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
