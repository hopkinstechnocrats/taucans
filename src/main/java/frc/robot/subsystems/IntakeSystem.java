package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSystem extends SubsystemBase {
    WPI_TalonSRX intakeMotor;
    public IntakeSystem(){
    intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);
    intakeMotor.configFactoryDefault();
    intakeMotor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void motorSpin(double speed){
    intakeMotor.set(speed);
    }
}
