package frc.robot.auto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands;
import frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.LauncherCommands;

public class autoRoutines{

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    public Command rotateClockwise90 =        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(1);
    public Command rotateCounterclockwise90 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command rotateClockwise45 =        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(1);
    public Command rotateCounterclockwise45 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command moveForward(double time) {return DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(time);};
    public Command m_rotationCommand;

    public Command auto_left_hook = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise90,
        moveForward(1)
    );

     public Command auto_left_curve = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise45,
        moveForward(1)
    );

     public Command auto_right_hook = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise90,
        moveForward(1)
    );

     public Command auto_right_curve = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise45,
        moveForward(1)
    );

    public Command auto_straight = new SequentialCommandGroup(
        moveForward(1)
    );

   public Command selectAuto(){
        autoChooser.setDefaultOption("Straight", auto_straight);
        autoChooser.addOption("Right Hook", auto_right_hook);
        autoChooser.addOption("Right Curve", auto_right_curve);
        autoChooser.addOption("Left Hook", auto_left_hook);
        autoChooser.addOption("Left Curve", auto_left_curve);
        SmartDashboard.putData("Are you starting on the left or right?", autoChooser);


        return autoChooser.getSelected();
    }

}