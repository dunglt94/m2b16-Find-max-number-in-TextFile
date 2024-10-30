import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> number = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader buffReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = buffReader.readLine()) != null) {
                number.add(Integer.parseInt(line));
            }
            buffReader.close();

        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi!");
            e.printStackTrace();
        }
        return number;
    }

    public void writeFile(String filePath, int maxNum) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter buffWriter = new BufferedWriter(writer);
            buffWriter.write("Giá trị lớn nhất là: " + maxNum + "\n");
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
