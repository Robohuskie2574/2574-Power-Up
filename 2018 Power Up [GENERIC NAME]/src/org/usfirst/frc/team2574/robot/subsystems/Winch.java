package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.RobotMap;
import org.usfirst.frc.team2574.robot.commands.StopWinch;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.	
	public static Spark winch = new Spark(RobotMap.winch);
	
	public Winch() {
		
	}
	
	public static void set(double speed) {
		winch.set(speed);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopWinch());
    }
}

