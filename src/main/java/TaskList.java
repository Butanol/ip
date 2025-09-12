import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task x) {
        tasks.add(x);
    }
    public void list() {
        System.out.println("Here are the tasks in your list:");
        if (tasks.isEmpty()) {
            System.out.println("Looks pretty empty ja. Populate it with tasks!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. " + tasks.get(i).toString() + "\n", i + 1);
        }
    }
    public void mark(int idx) throws UnsuccessfulException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new UnsuccessfulException("Task not found");
        }
        tasks.get(idx - 1).mark();
    }
    public void unmark(int idx) throws UnsuccessfulException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new UnsuccessfulException("Task not found");
        }
        tasks.get(idx - 1).unmark();
    }
    public void remove(int idx) throws ChatException {
        if (idx > this.tasks.size() || idx <= 0) {
            throw new UnsuccessfulException("Task not found");
        }
        tasks.remove(idx - 1);
    }
    public Task getTask(int idx) {
        if (idx >= tasks.size()) {
            System.out.println("Invalid Task");
            return null;
        }
        return tasks.get(idx);
    }
    public void saveToFile() throws IOException {
        Path folder = Paths.get("data");
        if (!Files.exists(folder)) {
            Files.createDirectories(folder); // create "data" folder if missing
        }
        File saveFile = Paths.get("data", "tasks.ser").toFile();
        FileOutputStream outputStream = new FileOutputStream(saveFile);
        ObjectOutputStream outputObject = new ObjectOutputStream(outputStream);
        for (Task t : tasks) {
            outputObject.writeObject(t);
        }
        outputObject.flush();
        outputObject.close();
    }

    /**
     * Loads saved tasks.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     *
     */
    public void loadTasks() throws IOException, UnsuccessfulException {
        File saveFile = Paths.get("data", "tasks.ser").toFile();
        if (!saveFile.exists()) {
            throw new UnsuccessfulException("File not found");
        }
        FileInputStream inputStream = new FileInputStream(saveFile);
        ObjectInputStream inputObject = new ObjectInputStream(inputStream);
        boolean isEmpty = true;
        int count = 0;
        while (isEmpty) {
            try {
                Task temp = (Task) inputObject.readObject();
                if (temp == null) {
                    isEmpty = false;
                } else {
                    tasks.add(temp);
                    count++;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Skipping Corrupted Task");
            } catch (EOFException e) {
                break;
            }
        }
        System.out.printf("Successfully loaded %d tasks\n", count);
    }
}
