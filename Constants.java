// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Can wiring
    public static final int RIGHT_BACK = 1;
    public static final int LEFT_FRONT = 2;
    public static final int RIGHT_FRONT = 3;
    public static final int LEFT_BACK = 4;
    public static final int INTAKE_FRONT = 5;
    public static final int INTAKE_BACK = 6;
    public static final int SHOOTER_BACK = 7;   
    public static final int SHOOTER_FRONT = 8;
    public static final int LIFT_FRONT = 9;
    public static final int TILT = 10;
    public static final int LIFT_BACK = 11 ;
   
    //controllor
    public static final int DRIVER_JOYSTICK_NUMBER = 0;
    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_LEFT_TRIGGER = 2;
    public static final int XBOX_RIGHT_TRIGGER = 3;
    public static final int DPAD_UP = 0;
    public static final int DPAD_DOWN = 180;
    public static final int DPAD_LEFT = 270;   
    public static final int DPAD_RIGHT = 90;
    

    //Speed
    public static final double DRIVETRAINSPEED = .7;
    public static final double INTAKE_SPEED = .5;
    public static final double OUTTAKE_SPEED = -.5;
    public static final double LIFT_UP_SPEED = .5;
    public static final double SHOOTER_SPEED = 1.0;
    public static final double LIFT_DOWN_SPEED = -.5;
    public static final double TILT_IN_SPEED = .7;
    public static final double TILT_OUT_SPEED = -.7;
    public static final double FRONT_SHOOTER_SPEED = 1.0;
    public static final double BACK_SHOOTER_SPEED = 1.0;
    public static final double FRONT_UNSHOOTER_SPEED = -.5;
    public static final double BACK_UNSHOOTER_SPEED = -.5;
    public static final double RAMP_SPEED = 0.5;
    
    

    //autonmous speed 
    public static final double AUTONOMOUS_DRIVE_FRONT_SPEED = .25;
    public static final double AUTONOMOUS_DRIVE_BACK_SPEED = -.5;
    public static final double TURN_180_LEFT = .25;
    public static final double TURN_180_RIGHT = -.25;

    //Time
    public static final double DRIVER_FORWARD_TIME = 2.0;
    public static final double INTAKE_FORWARD_TIME = 2.0;
    public static final double SHOOTER_FORWARD_TIME = 3.0;
    public static final double DRIVE_BACKWARD_TIME = 1.5;
    public static final double DRIVER_TURN_TIME = 0;
    
   
    //Camera
    public static final int CAMERA_RES_X = 320;
    public static final int CAMERA_RES_Y = 240;
            
}
