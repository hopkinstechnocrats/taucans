package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    WPI_TalonSRX intakeMotor;
    public IntakeSubsystem(){
    intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);
    intakeMotor.configFactoryDefault();
    intakeMotor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void motorSpin(double speed){
    intakeMotor.set(speed);
    }
}
