package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.OI;
import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class RotateArm extends Command{
	CANTalon defenseArm = RobotMap.defenseArmLeft;
	int testNumber;
	
	public RotateArm() {
		requires(Robot.defenseArm);
	}
	@Override
	protected void initialize() {
//		defenseArm.changeControlMode( CANTalon.TalonControlMode.Position );
//    	defenseArm.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot); // There is a chance an AnalogEncoder could be correct
//		defenseArm.reverseSensor(false);
//		defenseArm.setPID( 100, 0, 0 );
//		defenseArm.disable();
		testNumber = 0;
	}

	@Override
	protected void execute() {
		double upDownValue = -OI.coStick.getRawAxis(1);
		
		if (Math.abs(upDownValue) < 0.2)  // dead band for xbox
			upDownValue = 0.0;
		
		upDownValue = upDownValue * upDownValue * upDownValue;
		
		upDownValue *= 2.0;
		
		double armAngle = Robot.defenseArm.getTargetAngle();
		armAngle += upDownValue;
		
		Robot.defenseArm.setTargetAngle(armAngle);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}
}
