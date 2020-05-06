import java.io.*;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "invalid";
        fromLine = 0;
        toLine = -100;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws java.io.IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder contentBuilder = new StringBuilder();

        String currentLine;
        boolean first = true;
        while ((currentLine = br.readLine()) != null) {
            if (!first) {
                contentBuilder.append("\n");
            } else first = false;
            contentBuilder.append(currentLine);
        }

        return contentBuilder.toString();
    }

    public String readLines() {
        try {
            String[] allLinesArray = read().split("\n");
            String[] neededLinesArray = new String[toLine - fromLine + 1];
            for (int i = fromLine - 1, counter = 0; i < toLine && i < allLinesArray.length; i++, counter++) {
                neededLinesArray[counter] = allLinesArray[i];
            }
            return String.join("\n", neededLinesArray);

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
