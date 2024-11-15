package frc.robot.auto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands;
import frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.DriveSubsystem;

public class autoRoutines{

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    public Command rotateClockwise90 =        DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(1);
    public Command rotateCounterclockwise90 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotate intake left = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotate intake right = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotate hoop left = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotate hoop right = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command rotateClockwise45 =        DriveCommands.drive(driveSubsystem, -0.5, 0.5).withTimeout(1);
    public Command rotateCounterclockwise45 = DriveCommands.drive(driveSubsystem, 0.5, -0.5).withTimeout(1);
    public Command moveForward(double time) {return DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1);};
    public Command launchBall() {return LauncherCommands.spinLauncher(null).withTimeout(1);};
    //TODO add numbers for how much we need to turn for intake/hoop

     public Command auto_left_curve = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise45,
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
        rotateClockwise90,
        rotateClockwise90,
        launchBall()
    );

    public Command auto_right_curve_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise45,
        moveForward(1),
        rotateClockwise45,
        rotateClockwise90,
        launchBall()
    );

    public Command auto_left_curve_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise45,
        moveForward(1),
        rotateCounterclockwise45,
        rotateCounterclockwise90,
        launchBall()
    );

    public Command auto_right_curve_double_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateClockwise45,
        moveForward(1),
        rotateClockwise45,
        rotateClockwise90,
        launchBall(),
        rotateClockwise90,
        rotateClockwise90,
        moveForward(1),
        rotateClockwise90,
        rotateClockwise90,
        launchBall()
    );

    public Command auto_left_curve_double_launch = new SequentialCommandGroup(
        moveForward(1),
        rotateCounterclockwise45,
        moveForward(1),
        rotateCounterclockwise45,
        rotateCounterclockwise90,
        launchBall(),
        rotateClockwise90,
        rotateClockwise90,
        moveForward(1),
        rotateClockwise90,
        rotateClockwise90,
        launchBall()
    );


   public Command selectAuto(){
        autoChooser.setDefaultOption("Straight", auto_straight);
        autoChooser.addOption("Straight Launch", auto_straight_launch);
        autoChooser.addOption("Right Curve", auto_right_curve);
        autoChooser.addOption("Right Curve Launch", auto_right_curve_launch);
        autoChooser.addOption("Right Curve Double Launch", auto_right_curve_double_launch);
        autoChooser.addOption("Left Curve", auto_left_curve);
        autoChooser.addOption("Left Curve Launch", auto_left_curve_launch);
        autoChooser.addOption("Left Curve Double Launch", auto_left_curve_double_launch);
       

        return autoChooser.getSelected();
    }

}