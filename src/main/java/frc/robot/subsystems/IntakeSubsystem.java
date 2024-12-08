package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    // Defining motors
    WPI_TalonSRX intakeMotor;
    public IntakeSubsystem(){
        // Configuring motor settings
        intakeMotor = new WPI_TalonSRX(Constants.intakeMotor);
        intakeMotor.configFactoryDefault();
        intakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    // Motor spin code
    public void motorSpin(){
        intakeMotor.set(Constants.motorSpinSpeed);
        
    }

    public void motorSpinReverse(){
        intakeMotor.set(Constants.motorSpinSpeed*-1);
    }

    public void brake(){
        intakeMotor.stopMotor();
    }
}