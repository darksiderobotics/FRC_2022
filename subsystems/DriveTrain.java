// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  WPI_TalonFX LeftFront;
  WPI_TalonFX LeftBack;
  WPI_TalonFX RightFront;
  WPI_TalonFX RightBack;
  MotorController LeftMotors;
  MotorController RightMotors;
  DifferentialDrive drive;

  

  public DriveTrain() {
    LeftFront = new WPI_TalonFX(Constants.LEFT_FRONT);
    LeftFront.setInverted(false);
    LeftFront.configOpenloopRamp(Constants.RAMP_SPEED);
    LeftFront.configClosedloopRamp(0);

    LeftBack = new WPI_TalonFX(Constants.LEFT_BACK);
    LeftBack.setInverted(false);
    LeftBack.configOpenloopRamp(Constants.RAMP_SPEED);
    LeftBack.configClosedloopRamp(0);

    RightFront = new WPI_TalonFX(Constants.RIGHT_FRONT);
    RightFront.setInverted(true);
    RightFront.configOpenloopRamp(Constants.RAMP_SPEED);
    RightFront.configClosedloopRamp(0);
    
    RightBack = new WPI_TalonFX(Constants.RIGHT_BACK);
    RightBack.setInverted(true);
    RightBack.configOpenloopRamp(Constants.RAMP_SPEED);
    RightBack.configClosedloopRamp(0);
 

    LeftMotors = new MotorControllerGroup(LeftFront, LeftBack);
    RightMotors = new MotorControllerGroup(RightFront, RightBack);
    drive = new DifferentialDrive(LeftMotors, RightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveWithJoysticks(XboxController controller, double speed) {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }
  public void driveForward(double speed) {
    drive.tankDrive(speed, speed);
  }
  public void Stop () {
    drive.stopMotor();
  }

  public void driveBackwards(double speed) {
    drive.tankDrive(speed, speed);
  }
  public void driveTurn180(double speed) {
    LeftMotors.set(speed);
    RightMotors.set(speed);
  }
}
