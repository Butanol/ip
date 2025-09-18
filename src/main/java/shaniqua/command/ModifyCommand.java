package shaniqua.command;

public abstract class ModifyCommand extends Command {
    protected int idx;
    public ModifyCommand(int idx) {
        this.idx = idx;
    }
}
