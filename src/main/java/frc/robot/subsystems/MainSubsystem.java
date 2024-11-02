package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MainSubsystem extends SubsystemBase {
    WPI_TalonSRX mainMechanism;

    public MainSubsystem() {
        mainMechanism = new WPI_TalonSRX(Constants.mainMechanismCANID);
        mainMechanism.configFactoryDefault();
        mainMechanism.setNeutralMode(NeutralMode.Brake);
    }

    public void move(double power) {
        mainMechanism.set(power);
      }
}
