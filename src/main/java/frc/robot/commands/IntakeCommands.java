package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommands extends Command {
    public static Command spinintake(IntakeSubsystem intakeSubsystem) {
        return Commands.run(
            () -> {
                intakeSubsystem.motorSpin(0.55);
            },
        intakeSubsystem);
    }
}
