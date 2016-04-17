/**
 * 
 */
package org.usfirst.frc.team2471.robot.commandgroups;

import org.usfirst.frc.team2471.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team2471.robot.commands.QueueShot;
import org.usfirst.frc.team2471.robot.commands.ResetGyroCommand;
import org.usfirst.frc.team2471.robot.commands.RotateArmToAngle;
import org.usfirst.frc.team2471.robot.commands.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ChevalAuto extends CommandGroup {
	public ChevalAuto() {
    	addSequential(new ResetGyroCommand());
    	addParallel(new RotateArmToAngle(20.0));
    	addParallel(new QueueShot());
    	addSequential(new DriveDistanceCommand(2, 0, 0.7));
    	addSequential(new DriveDistanceCommand(1.1, 0, 0.3));
    	addSequential(new WaitCommand(0.5));
    	
    	addSequential(new ChevalHelper());

    	addSequential(new RotateToAngle( 0.0, 0.5, 2.0 ));
    	addSequential(new WaitCommand(1));
    	
    	addSequential(new BackUntilOuterWorks(0.4), 1.5);
    	addSequential(new AimAndShootGroup(true));
	}
}
