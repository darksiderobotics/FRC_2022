// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  CANSparkMax liftFront;
  CANSparkMax liftBack;
  static MotorController Lift;
  
  /** Creates a new Lift. */
  public Lift() {
    liftFront = new CANSparkMax(Constants.LIFT_FRONT, MotorType.kBrushless);
    liftFront.setInverted(false);

    liftBack = new CANSparkMax(Constants.LIFT_BACK, MotorType.kBrushless);
    liftBack.setInverted(true);

    Lift = new MotorControllerGroup(liftFront, liftBack);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void liftUp (double speed) {
    Lift.set(speed);
  }

  public void LiftDown(double speed) {
    Lift.set(speed);
    }

  public void stop() {
    Lift.set(0);
  }
}
