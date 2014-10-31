 
package ca.team4519.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import ca.team4519.lib.Loopable;
/**
 *
 * @author Connor Adams
 */
public class DriverController extends Joystick implements Loopable{

    
     public DriverController( int port){
        super(port);
    }
    
    public double getLeftDriveStick(){
        return getRawAxis(2);
    }
    
    public double getRightDriveStick(){
        return getRawAxis(5);
    }
    
    public boolean getShiftButton(){
        return getRawButton(6);
    }

    public void update() {
    
    }



}
