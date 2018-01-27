package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.commands.LiftUp;
import org.usfirst.frc.team2574.robot.commands.StopLift;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static WPI_TalonSRX lift = new WPI_TalonSRX(5);
	
	public Lift() {
		
	}
	
	public static void set(double speed) {
		lift.set(speed);
	}
	
	public static void timedset(double speed, double time) {  //creates a lift.set that also includes a time option
		double start = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() < (start + time) ) {
    		set(speed);
    		Timer.delay(.025);
    	}
    	set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopLift());
    }
}

