package Shaniqua.Command;

import Shaniqua.ShaniquaException;

public class CommandFailException extends ShaniquaException {
    CommandFailException(String msg) {
        super("Command Failed: " + msg);
    }
}
