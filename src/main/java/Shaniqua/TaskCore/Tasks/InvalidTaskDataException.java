package Shaniqua.TaskCore.Tasks;

import Shaniqua.ShaniquaException;

public class InvalidTaskDataException extends ShaniquaException {
    InvalidTaskDataException(String msg) {
        super("Invalid task data entry: " + msg);
    }
    InvalidTaskDataException() {
    }
}
