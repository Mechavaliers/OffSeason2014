 
package ca.team4519.frc2014;

import ca.team4519.frc2014.subsystems.DriveBase;
import ca.team4519.frc2014.subsystems.Intake;
import ca.team4519.frc2014.subsystems.Shooter;
import ca.team4519.frc2014.subsystems.*;
import ca.team4519.lib.MultiLooper;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;


public class MechaRobot {
        
  public static final DriveBase driveBase = new DriveBase();
  public static final Shooter shooter = new Shooter();
  public static final Intake intake = new Intake();
  public static final Compressor compressor = new Compressor(Constants.pressureSwitch.getInt(), Constants.compressorRelay.getInt());  
  
  public static final Joystick gamePad = new Joystick(Constants.gamepadPort.getInt());
  public static final Joystick operatorBoard = new Joystick(Constants.operatorBoard.getInt());
  
  public static MultiLooper subsystemUpdater100Hz = new MultiLooper(1.0 / 100.0);
    
  
  
public static void initRobot() {
    // Add all subsystems to a 100Hz Looper
    subsystemUpdater100Hz.addLoopable(driveBase);
    subsystemUpdater100Hz.addLoopable(intake);
    subsystemUpdater100Hz.addLoopable(shooter);
    
    
    compressor.start();
    }
}