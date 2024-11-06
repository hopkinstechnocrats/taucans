package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ConveyorSubsystem;

public class ConveyorCommands extends Command {

    public static Command conveyorToggle(ConveyorSubsystem conveyor) {
        return Commands.run(
          () -> {
            conveyor.motorSpin();
          },
          conveyor);
    }

}
