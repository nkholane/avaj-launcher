package folder1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public ArrayList<String> readFile(String textFile) throws ErrorHandler {
        ArrayList<String> content = new ArrayList<>();

        try {
            File file = new File(textFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                content.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new ErrorHandler("File missing");
        }
        try {
            int sim = Integer.parseInt(content.get(0));
            if (sim <= 0) {
                throw new ErrorHandler("Sim count should be positive");
            }
        } catch (NumberFormatException e) {
            throw new ErrorHandler("Please pass a number");
        }

        for (int i = 1; i < content.size(); i++) {
            String[] row = content.get(i).split(" ");
            if (row.length != 5)
                throw new ErrorHandler("Incorrect aircraft format");
            if (!row[0].equals("Baloon") && !row[0].equals("JetPlane") && !row[0].equals("Helicopter")) {
                throw new ErrorHandler("Incorrect aircraft name");
            }
            try {
                int a = Integer.parseInt(row[2]);
                int b = Integer.parseInt(row[3]);
                int c = Integer.parseInt(row[4]);
                if (a <= 0 || b <= 0 || c <= 0)
                    throw new ErrorHandler("Coordinates cant be negative");
            } catch (NumberFormatException e) {
                throw new ErrorHandler("Coordinates must be numbers");
            }
        }
        return content;
    }
}

