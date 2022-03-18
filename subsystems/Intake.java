// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  CANSparkMax intakeFront;
  CANSparkMax intakeBack;
  static MotorController intake;

  /** Creates a new Intake. */
  public Intake() {
    intakeFront = new CANSparkMax(Constants.INTAKE_FRONT, MotorType.kBrushless);
    intakeFront.setInverted(true);
    intakeBack = new CANSparkMax(Constants.INTAKE_BACK, MotorType.kBrushless);
    intakeBack.setInverted(false);
    intake = new MotorControllerGroup(intakeFront, intakeBack);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeball(XboxController contoller, double speed) {
    intake.set(contoller.getRawAxis(Constants.XBOX_RIGHT_TRIGGER)*speed);
  }

  public void outtakeball(double speed) {
    intake.set(speed);
  }
  public static void IntakeForward(double speed) {
    intake.set(speed);
  }

  public void stop() {
    intake.set(0);
  }
}
