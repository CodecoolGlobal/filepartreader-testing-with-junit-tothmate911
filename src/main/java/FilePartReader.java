import java.io.*;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "invalid";
        fromLine = 0;
        toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read () throws java.io.IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder contentBuilder = new StringBuilder();
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            contentBuilder.append(currentLine).append("\n");
        }
        return contentBuilder.toString();
    }

    public String readLines () {
        try {
            String[] allLines = read().split("\n");
            StringBuilder sb = new StringBuilder();
            for (int i = fromLine - 1; i < toLine && i < allLines.length; i++) {
                sb.append(allLines[i]).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
