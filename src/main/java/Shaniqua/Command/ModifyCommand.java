package Shaniqua.Command;

public abstract class ModifyCommand extends Command{
    int idx;
    public ModifyCommand(int idx) {
        this.idx = idx;
    }
}
