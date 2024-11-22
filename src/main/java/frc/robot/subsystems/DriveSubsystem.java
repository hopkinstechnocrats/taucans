// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // Initialize all the variables so we can use them later

  DifferentialDrive drive;
  public DigitalInput limitSwitch;

  //private final DriveSubsystemIO io;
  private final DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();
  

  // DriveSubsystem contains all the code for what we want our DriveSubsystem to be
  public DriveSubsystem() {
    // Tell our drive command what type of drive we want to use and what motors to use
  }

  // Create our drive command
  public void drive(double left, double right) {
    //Tell our drive command to act as a tank drive. Other valid option is Arcade drive
    drive.tankDrive(left, right);
    /*
    readable log printed to roboRIO log accessable from VScode
    System.out.println("left: "+ left+ ", right: "+ right);
    */
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}