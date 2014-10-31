 
package ca.team4519.frc2014.subsystems;

import ca.team4519.lib.Subsystem;
import ca.team4519.frc2014.Constants;
import ca.team4519.lib.Loopable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import java.util.Hashtable;
        
public class Shooter extends Subsystem implements Loopable{
       
    double power = Constants.rearmSpeed.getDouble();
    private Talon catapultMotor = new Talon(Constants.catapultMotor.getInt());
    private DigitalInput shotReady = new DigitalInput(Constants.catapultSwitch.getInt());
    
    
    
    public Shooter(){
    super("Shooter");
    }
  
     
    public boolean shotReady(){
      return shotReady.get();
    }
    
    public void shoot(){
        catapultMotor.set(power);
    }
    
    public Talon catapultMotor(){
        return catapultMotor;
    }
    
    public Hashtable serialize() {
    Hashtable motor = new Hashtable();
  
    motor.put("catapultMotor", new Double(catapultMotor.get()));
    
    data.put("motor", motor);
       return data;
  }
    public void update(){
    SmartDashboard.putNumber("catapultMotor",catapultMotor.get());
    SmartDashboard.putBoolean("shotReady", shotReady());
    
    }    
}
