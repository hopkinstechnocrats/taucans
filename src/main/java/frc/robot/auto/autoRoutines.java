package frc.robot.auto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands;
import frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

public class autoRoutines{

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    public Command rotateClockwise90 =        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(1);
    public Command rotateCounterclockwise90 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command rotateClockwise45 =        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(1);
    public Command rotateCounterclockwise45 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command moveForward(double time) {return DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1);};
    public Command launchBall() {return LauncherCommands.spinLauncher(null).withTimeout(1);};

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
        moveForward(2)
    );

    public Command auto_straight_launch = new SequentialCommandGroup(
        moveForward(2),
        launchBall()
    );

    public Command auto_right_curve_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise45,
        moveForward(1),
        rotateCounterclockwise45,
        launchBall()
    );

    public Command auto_left_curve_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise45,
        moveForward(1),
        rotateClockwise45,
        launchBall()
    );

     public Command auto_left_hook_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise90,
        moveForward(1),
        rotateClockwise90,
        launchBall()
    );

     public Command auto_right_hook_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise90,
        moveForward(1),
        rotateCounterclockwise90,
        launchBall()
    );

   public Command selectAuto(){
        autoChooser.setDefaultOption("Straight", auto_straight);
        autoChooser.setDefaultOption("Straight Launch", auto_straight_launch);
        autoChooser.addOption("Right Hook", auto_right_hook);
        autoChooser.addOption("Right Hook", auto_right_hook);
        autoChooser.addOption("Right Curve", auto_right_curve);
        autoChooser.addOption("Right Curve Launch", auto_right_curve_launch);
        autoChooser.addOption("Left Hook", auto_left_hook);
        autoChooser.addOption("Left Curve", auto_left_curve);
        autoChooser.addOption("Left Curve Launch", auto_left_curve_launch);
        SmartDashboard.putData("Are you starting on the left or right?", autoChooser);


        return autoChooser.getSelected();
    }

}