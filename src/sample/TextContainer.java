package sample;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(pathForFile = "C:\\Users\\Vlad\\Desktop\\file.txt")
public class TextContainer {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Saver
    public void save(String getPath) throws IOException {
        try (FileWriter fw = new FileWriter(getPath)) {
            fw.write(this.text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
