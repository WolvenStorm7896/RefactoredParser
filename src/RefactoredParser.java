import java.io.*;
import java.util.HashSet;
public class RefactoredParser {
    public static void main(String[] args) {
        HashSet<String> firstKazFile = new HashSet<>();
        HashSet<String> secondKazFile = new HashSet<>();
        HashSet<String> firstRusFile = new HashSet<>();
        HashSet<String> secondRusFile = new HashSet<>();
        HashSet<String> processedFileOne = new HashSet<>();
        HashSet<String> processedFileTwo = new HashSet<>();
        HashSet<String> processedFileOneRus = new HashSet<>();
        HashSet<String> processedFileTwoRus = new HashSet<>();
        String doc1kaz = "src\\doc1(kaz).csv";
        String doc2kaz = "src\\doc2(kaz).csv";
        String doc1rus = "src\\doc1(rus).csv";
        String doc2rus = "src\\doc2(rus).csv";
        class EasyFileReader {
            EasyFileReader(String fileName, HashSet<String> finalFile) {
                try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        finalFile.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        EasyFileReader file1kaz = new EasyFileReader(doc1kaz, firstKazFile);
        EasyFileReader file2kaz = new EasyFileReader(doc2kaz, secondKazFile);
        EasyFileReader file1rus = new EasyFileReader(doc1rus, firstRusFile);
        EasyFileReader file2rus = new EasyFileReader(doc2rus, secondRusFile);
        for (String s: firstKazFile) {
            if(!secondKazFile.contains(s)) {
                processedFileOne.add(s);
            }
        }
        for (String s: secondKazFile) {
            if (!firstKazFile.contains(s)) {
                processedFileTwo.add(s);
            }
        }
        for (String s: firstRusFile) {
            if (!secondRusFile.contains(s)) {
                processedFileOneRus.add(s);
            }
        }
        for (String s: secondRusFile) {
            if (!firstRusFile.contains(s)) {
                processedFileTwoRus.add(s);
            }
        }
        System.out.println("Count of unique elements of first kaz file are: \n" + processedFileOne);
        System.out.println("Count of unique elements of first kaz file are: \n" + processedFileTwo);
        System.out.println("Count of unique elements of first kaz file are: \n" + processedFileOneRus);
        System.out.println("Count of unique elements of first kaz file are: \n" + processedFileTwoRus);
    }
}



