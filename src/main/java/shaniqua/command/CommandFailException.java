package shaniqua.command;

import shaniqua.ShaniquaException;

public class CommandFailException extends ShaniquaException {
    CommandFailException(String msg) {
        super("Command Failed: " + msg);
    }
}
