package org.usfirst.frc.team2471.robot.commandgroups;

import org.usfirst.frc.team2471.robot.commands.Aim2;
import org.usfirst.frc.team2471.robot.commands.RotateArmToAngle;
import org.usfirst.frc.team2471.robot.commands.Shoot;
import org.usfirst.frc.team2471.robot.commands.StartShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAndShootGroup extends CommandGroup {
    
    public AimAndShootGroup(boolean fastMode) {
    	addSequential( new StartShooter() );
    	
    	addSequential( new RotateArmToAngle(-5.0));

    	addSequential( new Aim2(true, fastMode));

    	addSequential( new Shoot() );

    	addSequential( new RotateArmToAngle(62.0));
    }
}
