package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class LauncherSubsystem extends SubsystemBase{
    WPI_TalonSRX launcherMotorTop;
    WPI_TalonSRX launcherMotorBottom;
    public LauncherSubsystem(){
    launcherMotorTop = new WPI_TalonSRX(Constants.intakeMotor);
    launcherMotorBottom = new WPI_TalonSRX(Constants.intakeMotor);
    launcherMotorTop.configFactoryDefault();
    launcherMotorBottom.configFactoryDefault();
    launcherMotorTop.setNeutralMode(NeutralMode.Brake);
    launcherMotorBottom.setNeutralMode(NeutralMode.Brake);
    }
    
    public void launcherSpin(){
        launcherMotorBottom.set(Constants.bottomLauncherSpeed);
        launcherMotorTop.set(Constants.topLauncherSpeed);
    }
}