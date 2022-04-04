import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static String constPath = "C://Games/";
  public static String constScr = "scr/";
  public static String constRes = "res/";

  static StringBuilder log = new StringBuilder();

  static void makeDirectory(String dirPath) {
    new File(dirPath).mkdir();
    log.append("Каталог " + dirPath + " создан \n");
  }

  static void makeFile(String fileName) throws IOException {
    try {
      if (new File(fileName).createNewFile()) {
        log.append("Файл " + fileName + " создан \n");
      }
    } catch (IOException ex) {
      log.append(ex.getMessage());
    }
  }

  public static void main(String[] args) throws IOException {

    makeDirectory(constPath + "scr");
    makeDirectory(constPath + constScr + "main");
    makeDirectory(constPath + constScr + "test");

    makeDirectory(constPath + "res");
    makeDirectory(constPath + constRes + "drawables");
    makeDirectory(constPath + constRes + "vectors");
    makeDirectory(constPath + constRes + "icons");

    makeDirectory(constPath + "savegames");
    makeDirectory(constPath + "temp");

    makeFile(constPath + constScr + "Main.java");
    makeFile(constPath + constScr + "Utils.java");
    makeFile(constPath + "temp/" + "temp.txt");

    try (FileWriter writer = new FileWriter(constPath + "temp/" + "temp.txt")) {
      writer.append(log);
    } catch (IOException ex) {
      log.append(ex.getMessage());
    }
  }
}

