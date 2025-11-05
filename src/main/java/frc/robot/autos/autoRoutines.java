package frc.robot.autos;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands;
import frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

public class autoRoutines{

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
    SendableChooser<Command> autoChooser = new SendableChooser<>(); 

    public Command rotateClockwise90        = DriveCommands.drive(driveSubsystem, -1, 1).withTimeout(0.5);
    public Command rotateCounterclockwise90 = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(0.5);
    //public Command rotateIntakeLeft       = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotateIntakeRight      = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotateHoopLeft         = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    //public Command rotateHoopRight        = DriveCommands.drive(driveSubsystem, 1, -1).withTimeout(1);
    public Command rotateClockwise45        = DriveCommands.drive(driveSubsystem, -0.5, 0.5).withTimeout(1);
    public Command rotateCounterclockwise45 = DriveCommands.drive(driveSubsystem, 0.5, -0.5).withTimeout(1);
    public Command moveForward(double time) {return DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1);};
    public Command launchBall() {return LauncherCommands.spinLauncher(launcherSubsystem).withTimeout(1);};

    public Command auto_straight_launch = new SequentialCommandGroup(
        DriveCommands.drive(driveSubsystem, 1, 1).withTimeout(1),
        LauncherCommands.spinLauncher(launcherSubsystem).withTimeout(1)
    );
    public Command do_nothing = new SequentialCommandGroup(
        Commands.waitSeconds(15)
     );

   public Command selectAuto(){
        autoChooser.setDefaultOption("Do Nothing", auto_straight_launch);


        return autoChooser.getSelected();
    }
}