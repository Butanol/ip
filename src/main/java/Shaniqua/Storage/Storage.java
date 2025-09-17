package Shaniqua.Storage;

import Shaniqua.TaskCore.TaskList;
import Shaniqua.TaskCore.Tasks.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {
    String filePath;
    Path folder;
    public Storage(String filePath) {
        this.filePath = filePath;
        folder = Paths.get(filePath);
    }
    public void saveToFile(TaskList t) throws IOException {
        if (!Files.exists(folder)) {
            Files.createDirectories(folder); // create "data" folder if missing
        }
        File saveFile = Paths.get("data", "tasks.ser").toFile();
        FileOutputStream outputStream = new FileOutputStream(saveFile);
        ObjectOutputStream outputObject = new ObjectOutputStream(outputStream);
        for (int i = 0; i < t.getLength(); i++) {
            outputObject.writeObject(t.getTask(i));
        }
        outputObject.flush();
        outputObject.close();
    }

    /**
     * Loads saved tasks.
     *
     * @throws IOException if
     *
     */
    public void loadTasks(TaskList t) throws StorageException {
        File saveFile = Paths.get(filePath, "tasks.ser").toFile();
        if (!Files.exists(folder) || !saveFile.exists()) {
            throw new StorageException("File not found");
        }
        try {
            FileInputStream inputStream = new FileInputStream(saveFile);
            ObjectInputStream inputObject = new ObjectInputStream(inputStream);
            boolean isEmpty = true;
            int count = 0;
            while (true) {
                try {
                    Task temp = (Task) inputObject.readObject();
                    if (temp != null) {
                        t.addTask(temp);
                        count++;
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Skipping Corrupted Task");
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.printf("Successfully loaded %d tasks\n", count);
        } catch (IOException e) {
            throw new StorageException("File not found");
        }
    }
}
