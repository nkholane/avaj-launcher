package folder1;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeToFile() throws ErrorHandler {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt");
            myWriter.write(Simulation.logger);
            myWriter.close();
            System.out.println("Successfully created simulation.txt.");
        } catch (IOException e) {
            throw new ErrorHandler("Error creating file");
        }
    }
}

