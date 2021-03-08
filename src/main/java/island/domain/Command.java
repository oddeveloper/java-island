package island.domain;

public enum Command {
    PROGRAM_EXIT(0),
    INITIALIZE(1),
    GENERATE(2),
    REMOVE(3),
    FILE_WRITE(4),
    FILE_READ(5);

    private int value;

    private Command(int value) {
        this.value = value;
    }

    public int getCommand() {
        return this.value;
    }

    public static Command getCommand(int value) {
        for (Command command : Command.values()) {
            if (value == command.value) {
                return command;
            }
        }
        throw new IllegalArgumentException("메뉴에 없는 명령입니다.");
    }
}

