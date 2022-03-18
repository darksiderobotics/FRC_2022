// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  static CANSparkMax shooterFront;
  static CANSparkMax shooterBack;
  static MotorController shooter;

  /** Creates a new Shooter. */
  public Shooter() {
    shooterFront = new CANSparkMax(Constants.SHOOTER_FRONT, MotorType.kBrushless);
    shooterFront.setInverted(false);
    
    shooterBack = new CANSparkMax(Constants.SHOOTER_BACK, MotorType.kBrushless);
    shooterBack.setInverted(true);

    shooter = new MotorControllerGroup(shooterFront, shooterBack);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shootball(XboxController controller, double speed) {
    shooterFront.set(controller.getRawAxis(Constants.XBOX_LEFT_TRIGGER)*speed);
    shooterBack.set(controller.getRawAxis(Constants.XBOX_LEFT_TRIGGER)*speed);
  }

  public void shooterfoward(double speed){
    shooter.set(Constants.SHOOTER_SPEED);
  }

  public void stop() {
    shooterFront.set(0);
    shooterBack.set(0);
  }

  public void unshootball(double speed) {
    shooterFront.set(speed);
    shooterBack.set(speed);
  }
}