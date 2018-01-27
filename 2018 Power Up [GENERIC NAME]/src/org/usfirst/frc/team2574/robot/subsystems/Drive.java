package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.RobotMap;
import org.usfirst.frc.team2574.robot.commands.TeleDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//public static TalonSRX variable = new TalonSRX(RobotMap.correspondingVariable);  --  general form for motor with TalonSRX motor controller
	public static WPI_TalonSRX leftF = new WPI_TalonSRX(RobotMap.leftFrontId);
	public static WPI_TalonSRX leftR = new WPI_TalonSRX(RobotMap.leftRearId);
	public static WPI_TalonSRX rightF = new WPI_TalonSRX(RobotMap.rightFrontId);
	public static WPI_TalonSRX rightR = new WPI_TalonSRX(RobotMap.rightRearId);
	
	public static MecanumDrive drive = new MecanumDrive(leftF, leftR, rightF, rightR);
	
	private static AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
    private static final double gyroPGain = 0.05;
    
    public static void cartesian(double x, double y, double rotation) {
    	// Sets up drive system for TeleDrive and subsequently, OI.
    	drive.driveCartesian(x, y , rotation, 0);
    }
    
    public static void driveStraight(double y, double time) {  //uses gyro to keep straight in autonomous for some y-axis power and some time
    	gyro.reset();
    	double start = Timer.getFPGATimestamp();
    	//this is to ensure that the start times being different run to run does not matter
    	while (Timer.getFPGATimestamp() < (start + time) ) {
    		cartesian(0,y,-getGyroAngle() * gyroPGain); //this is so it rotates ever so slightly to correct it not driving straight
    		Timer.delay(.025);
    	}
    	cartesian(0,0,0);
    }
    
    public static AnalogGyro getGyro() {  //gets gyro value
    	return gyro;
    }
    
    public static double getGyroAngle() {  //returns gyro angle value
    	return gyro.getAngle();
    }
    
    public static void resetGyro() {  //resets the gyro so that it is the same each time the robot powers up
    	gyro.calibrate();
    	gyro.reset();
    }
    
    public static void safety(boolean enabled) {
    	//sets up safety for autonomous
    	drive.setSafetyEnabled(enabled);
    }
    
    public static boolean safety() {
    	//returns safety for autonomous
    	return drive.isSafetyEnabled();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleDrive());
    }
}

