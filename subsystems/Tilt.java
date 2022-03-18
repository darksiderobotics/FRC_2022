// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tilt extends SubsystemBase {
  static CANSparkMax tilt;
  /** Creates a new Tilt. */
  public Tilt() {
    tilt = new CANSparkMax(Constants.TILT, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tiltIn(double speed) {
    tilt.set(speed);
  }

  public void tiltOut(double speed) {
    tilt.set(speed);
  }
  
  public void stop() {
    tilt.set(0);
  }
}