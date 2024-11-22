package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

/**
 * This drive implementation is for Talon SRXs driving brushed motors (e.g. CIMS) with no encoders
 * and no gyro.
 */
public class DriveSubsystemIOTalonSRX implements DriveSubsystemIO {
  WPI_TalonSRX leftLeader;
  WPI_TalonSRX leftFollower;
  WPI_TalonSRX rightLeader;
  WPI_TalonSRX rightFollower;

  public DriveSubsystemIOTalonSRX() {
    var config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 60;
    config.peakCurrentDuration = 250;
    config.continuousCurrentLimit = 40;
    config.voltageCompSaturation = 12.0;
    
    // Create the motors in code
    leftLeader = new WPI_TalonSRX(Constants.leftLeaderCANID);
    leftFollower = new WPI_TalonSRX(Constants.leftFollowerCANID);
    rightLeader = new WPI_TalonSRX(Constants.rightLeaderCANID);
    rightFollower = new WPI_TalonSRX(Constants.rightFollowerCANID);
    
    // Set motors to default settings
    leftLeader.configFactoryDefault();
    leftFollower.configFactoryDefault();
    rightLeader.configFactoryDefault();
    rightFollower.configFactoryDefault();

    // Tell motors to brake when not given any other command
    leftLeader.setNeutralMode(NeutralMode.Brake);
    rightLeader.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    // Tell the follower motors to do what the Lead motors are doing
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    // Set the left motors to inverted because they face the opposite direction of the right motors
    leftLeader.setInverted(true);
    leftFollower.setInverted(true);
  }

  @Override
  public void updateInputs(DriveIOInputs inputs) {
    inputs.leftAppliedVolts = leftLeader.getMotorOutputVoltage();
    inputs.leftCurrentAmps =
        new double[] {leftLeader.getSupplyCurrent(), leftFollower.getSupplyCurrent()};

    inputs.rightAppliedVolts = rightLeader.getMotorOutputVoltage();
    inputs.rightCurrentAmps =
        new double[] {rightLeader.getSupplyCurrent(), rightFollower.getSupplyCurrent()};
  }
}