package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorSubsystem extends SubsystemBase{
    WPI_TalonSRX conveyorMotor;
    public ConveyorSubsystem(){
    conveyorMotor = new WPI_TalonSRX(Constants.conveyorMotor);
    conveyorMotor.configFactoryDefault();
    conveyorMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void motorSpin(){
        conveyorMotor.set(Constants.motorSpinSpeed);
    }
}
