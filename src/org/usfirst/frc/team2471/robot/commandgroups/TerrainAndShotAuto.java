package org.usfirst.frc.team2471.robot.commandgroups;

import org.usfirst.frc.team2471.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team2471.robot.commands.QueueShot;
import org.usfirst.frc.team2471.robot.commands.ResetGyroCommand;
import org.usfirst.frc.team2471.robot.commands.RotateArmToAngle;
import org.usfirst.frc.team2471.robot.commands.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TerrainAndShotAuto extends CommandGroup {
    
    public  TerrainAndShotAuto() {
    	addSequential(new ResetGyroCommand());
    	addParallel(new RotateArmToAngle(0.0));
    	addParallel(new QueueShot());
    	addSequential(new DriveDistanceCommand(12, 0, 0.9)); //Changed from 
    	addSequential(new DriveDistanceCommand(4, 0, 0.4));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new DriveDistanceCommand(1.5, 0.0, -0.4));
    	addSequential(new RotateArmToAngle(0.0));
    	addSequential(new WaitCommand(1.0));

    	/*
    	//addSequential(new TurnUntilBlobFound(0.5), 2.0);
    	addSequential(new RingLightCommand(true));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new StartShooter());
    	addSequential(new Aim2(true));
    	addSequential(new Shoot());
    	addSequential(new RotateToAngle(0, 0.5, 5.0));
    	//addSequential(new DriveDistanceCommand(10, 0, -0.7));
    	 */
    	addSequential(new BackUntilOuterWorks(0.4), 1.5);
    	addSequential(new AimAndShootGroup(true));
    	
    	addSequential(new DriveDistanceCommand(0.5, 0.0, -0.5));
    	addSequential(new RotateToAngle(0, 0.5, 2.0));
    	addSequential(new DriveDistanceCommand(8.0, 0.0, -0.8));
    }
}
