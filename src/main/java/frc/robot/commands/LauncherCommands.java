package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.LauncherSubsystem;
public class LauncherCommands extends Command {

    public static Command spinLauncher(LauncherSubsystem launcherSubsystem) {
        return Commands.run(
            () -> {
                launcherSubsystem.launcherSpin();
            },
        launcherSubsystem);
    }
    
    public static Command launcherReverse(LauncherSubsystem launcherSubsystem) {
        return Commands.run(
            () -> {
                launcherSubsystem.launcherReverse();
            },
        launcherSubsystem);
    }
    public static Command brake(LauncherSubsystem launcherSubsystem) {
        return Commands.run(
            () -> {
                launcherSubsystem.brake();
            },
        launcherSubsystem);
    }
}