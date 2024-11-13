package frc.robot.auto;

import java.util.List;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.commands.driveingexample;
//TODO fix with real code
import frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.DriveSubsystem;

public class autoRoutines {

    private final DriveSubsystem m_driveTrain;

    

    public autoRoutines(DriveSubsystem m_driveTrain) {
        this.m_driveTrain = m_driveTrain;       
    }

    public Command DriveAutoSimple(){
        final DriveTime m_driveTime1 = new DriveTime(m_driveTrain, -0.55, -0.55, 3);
        final DriveTime m_driveTime4 = new DriveTime(m_driveTrain, -0.55, 0.55, 0.5);
        final ConveyorSpin m_ConveyorSpin1;
        return new SequentialCommandGroup(
        m_driveTime1
    );
    }
}