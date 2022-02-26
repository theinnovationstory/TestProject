// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax FL;
  private CANSparkMax BL;
  private MotorControllerGroup leftSide;
  private CANSparkMax FR;
  private CANSparkMax BR;
  private MotorControllerGroup rightSide;

  private DifferentialDrive driveTrain;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    this.FL = new CANSparkMax(DriveConstants.FL_id, MotorType.kBrushless);
    this.BL = new CANSparkMax(DriveConstants.BL_id, MotorType.kBrushless);
    this.leftSide = new MotorControllerGroup(this.FL, this.BL);

    this.FR = new CANSparkMax(DriveConstants.FR_id, MotorType.kBrushless);
    this.BR = new CANSparkMax(DriveConstants.BR_id, MotorType.kBrushless);
    this.leftSide = new MotorControllerGroup(this.FR, this.BR);

    this.driveTrain = new DifferentialDrive(this.leftSide, this.rightSide);
    this.driveTrain.setDeadband(0.05);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeInbuilt(double speedValue, double turnValue) {
    this.driveTrain.arcadeDrive(speedValue, turnValue);
  }
}
