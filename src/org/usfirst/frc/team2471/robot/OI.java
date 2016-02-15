package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.Aim;
import org.usfirst.frc.team2471.robot.commands.SpitOutBall;
import org.usfirst.frc.team2471.robot.commands.SuckUpBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public static Joystick driverStick, coStick;
	public static JoystickButton shootButton;
	public static JoystickButton aimButton;
	public static JoystickButton armRotateUpButton;
	public static JoystickButton armRotateDownButton;
	public static JoystickButton spitOut;
	public static JoystickButton suckIn;
	public static JoystickButton toggleWindup;
	
	public OI(){
		driverStick = new Joystick(0);
		coStick = new Joystick(1);
		
		/*shootButton = new JoystickButton(coStick, 1);
		shootButton.whileHeld(new Shoot());*/
		
		aimButton = new JoystickButton(driverStick, 1);
		aimButton.whenPressed(new Aim());
		
		spitOut = new JoystickButton(coStick, 1);
		spitOut.whileHeld(new SpitOutBall());
		
		suckIn = new JoystickButton(coStick, 4);
		suckIn.whileHeld(new SuckUpBall());
	}
}

