package island;

import island.domain.Command;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {

    @ParameterizedTest
    @EnumSource(Command.class)
    void getValueForCommand(Command command) {
        int commandNumber = command.getCommand();
        assertTrue(commandNumber >= 0 && commandNumber < 6);
    }

}
