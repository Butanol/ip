package Shaniqua.Parser;

import Shaniqua.Command.*;
import Shaniqua.TaskCore.Tasks.Deadline;
import Shaniqua.TaskCore.Tasks.Event;
import Shaniqua.TaskCore.Tasks.InvalidTaskDataException;
import Shaniqua.TaskCore.Tasks.Todo;

public class Parser {
    public static Command parse(String in) throws ParserException, InvalidTaskDataException {
        String[] processedIn = handleInput(in);
        int idx;
        return switch (processedIn[0]) {
            case "bye" -> {
                System.out.println("Bye. Hope to see you again soon!");
                yield new ExitCommand();
            }
            case "list" -> {
                yield new ListCommand();
            }
            case "mark" -> {
                if (!isInteger(processedIn[1])) {
                    throw new ParserException();
                }
                idx = Integer.parseInt(processedIn[1]);
                yield new MarkCommand(idx);
            }
            case "unmark" -> {
                if (!isInteger(processedIn[1])) {
                    throw new ParserException();
                }
                idx = Integer.parseInt(processedIn[1]);
                yield new UnmarkCommand(idx);
            }
            case "remove" -> {
                if (!isInteger(processedIn[1])) {
                    throw new ParserException();
                }
                idx = Integer.parseInt(processedIn[1]);
                yield new DeleteTaskCommand(idx);
            }
            case "todo" -> {
                yield new AddTaskCommand(new Todo(processedIn[1]));
            }
            case "deadline" -> {
                String[] paramsDeadline = handleDeadline(processedIn[1]);
                yield new AddTaskCommand(new Deadline(paramsDeadline[0],
                        paramsDeadline[1]));
            }
            case "event" -> {
                String[] paramsEvents =
                        handleEvent(processedIn[1]);
                yield new AddTaskCommand(new Event(paramsEvents[0], paramsEvents[1],
                        paramsEvents[2]));
            }
            case "save" -> {
                yield new StoreCommand();
            }
            case "load" -> {
                System.out.println("Doing so will replace the entire list. Are you sure? (y/n)");
                yield new LoadCommand();
            }
            default -> {
                yield null;
            }
        };
    }
    /**
     *
     * @param param input string
     * @return String without the first argument
     */
    private static String[] handleInput(String param) {
        String[] temp = param.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            res.append(temp[i]);
            res.append(" ");
        }
        return new String[]{temp[0], res.toString().trim()};
    }

    private static String[] handleDeadline(String param) throws ParserException {
        String[] res = param.split("/by");
        if (res.length < 2) throw new ParserException();
        return new String[]{res[0].trim(), res[1].trim()};
    }
    private static String[] handleEvent(String param) throws ParserException {
        String[] res = param.split(" ");
        String[] reorderedString = new String[3];
        if (res.length < 5) throw new ParserException();
        reorderedString[0] = res[0];
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i].trim();
            if (res[i].isEmpty()) {
                throw new ParserException();
            }
            if (res[i].equals("/to")) {
                if (i + 1 >= res.length) {
                    throw new ParserException();
                }
                reorderedString[2] = res[i + 1].trim();
            } else if (res[i].equals("/from")) {
                if (i + 1 >= res.length) {
                    throw new ParserException();
                }
                reorderedString[1] = res[i + 1].trim();
            }
        }
        return reorderedString;
    }
    private static boolean isInteger(String param) {
        try {
            Integer.valueOf(param);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
