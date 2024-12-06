package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommands extends Command {

    public static Command intakeToggle(IntakeSubsystem intake) {
        return Commands.run(
          () -> {
            intake.motorSpin();
            
          },
          intake);
    }

    public static Command intakeToggleReverse(IntakeSubsystem intake) {
        return Commands.run(
          () -> {
            intake.motorSpinReverse();
          },
          intake);
    }

    public static Command brake(IntakeSubsystem intake){
      return Commands.run(
        () -> {
          intake.brake();
      }, intake);
    }



}