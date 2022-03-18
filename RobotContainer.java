// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.IntakeTime;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftUp;
import frc.robot.commands.OuttakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.ShooterTimed;
import frc.robot.commands.TiltIn;
import frc.robot.commands.TiltOut;
import frc.robot.commands.UnShootBall;
import frc.robot.commands.AutonomousOne;
import frc.robot.commands.AutonomousTwo;
import frc.robot.commands.DriveBackwardTimed;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveTurn180Timed;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tilt;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  private final DriveBackwardTimed driveBackwardTimed;
  private final DriveTurn180Timed driveturn180Timed;

  private final Shooter shooter;
  private final ShootBall shootball;
  private final UnShootBall unshootball;
  private final ShooterTimed shooterTimed;
  
  private final Intake intake;
  private final IntakeBall intakeBall;
  private final OuttakeBall outtakeBall;
  private final IntakeTime intaketime;

  private final Lift lift;
  private final LiftUp liftUp;
  private final LiftDown liftDown;

  private final Tilt tilt;
  private final TiltIn tiltIn;
  private final TiltOut tiltOut;

  public static XboxController driverJoystick;

  private final AutonomousOne autonomousOne;
  private final AutonomousTwo autonomousTwo;

  SendableChooser<Command> chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);
    driveBackwardTimed = new DriveBackwardTimed(driveTrain);
    driveBackwardTimed.addRequirements(driveTrain);
    driveturn180Timed = new DriveTurn180Timed(driveTrain);
    driveturn180Timed.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);      
    
    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK_NUMBER);

    shooter = new Shooter();
    shootball = new ShootBall(shooter);
    shootball.addRequirements(shooter);
    shooter.setDefaultCommand(shootball);
    unshootball = new UnShootBall(shooter);
    unshootball.addRequirements(shooter);
    shooterTimed = new ShooterTimed(shooter);
    shooterTimed.addRequirements(shooter);

    intake = new Intake();
    intakeBall = new IntakeBall(intake);
    intakeBall.addRequirements(intake);
    intake.setDefaultCommand(intakeBall);
    outtakeBall = new OuttakeBall(intake);
    outtakeBall.addRequirements(intake);
    intaketime = new IntakeTime(intake);
    intaketime.addRequirements(intake);

    lift = new Lift();
    liftUp = new LiftUp(lift);
    liftUp.addRequirements(lift);
    liftDown = new LiftDown(lift);
    liftDown.addRequirements(lift); 

    tilt = new Tilt();
    tiltOut = new TiltOut(tilt);
    tiltOut.addRequirements(tilt);
    tiltIn = new TiltIn(tilt);
    tiltIn.addRequirements(tilt);
    
    autonomousOne = new AutonomousOne(shooter, driveTrain);
    autonomousTwo = new AutonomousTwo(driveTrain, intake, shooter);
    
    chooser.addOption("Autonomous Two", autonomousTwo);
    chooser.setDefaultOption("Autonomous One", autonomousOne);
    SmartDashboard.putData("Autonomous", chooser);

    SmartDashboard.putData(shooter);
    SmartDashboard.putData(driveTrain);
    SmartDashboard.putData(intake);
    SmartDashboard.putData(lift);
    SmartDashboard.putData(tilt);


    //Camera
    edu.wpi.first.cscore.UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton Outtakebutton = new JoystickButton(driverJoystick, XboxController.Button.kRightBumper.value);
    Outtakebutton.whenHeld(new OuttakeBall(intake)); 

    JoystickButton unshootbutton = new JoystickButton(driverJoystick, XboxController.Button.kLeftBumper.value);
    unshootbutton.whenHeld(new UnShootBall(shooter));

    JoystickButton tiltInbutton = new JoystickButton(driverJoystick, XboxController.Button.kX.value);
    tiltInbutton.whenHeld(new TiltIn(tilt));

    JoystickButton tiltOutbutton = new JoystickButton(driverJoystick, XboxController.Button.kB.value);
    tiltOutbutton.whenHeld(new TiltOut(tilt));

    JoystickButton liftUpbutton = new JoystickButton(driverJoystick, XboxController.Button.kY.value);
    liftUpbutton.whenHeld(new LiftUp(lift));

    JoystickButton liftDownbutton = new JoystickButton(driverJoystick, XboxController.Button.kA.value);
    liftDownbutton.whenHeld(new LiftDown(lift));

  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}