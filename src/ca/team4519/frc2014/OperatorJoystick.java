 
package ca.team4519.frc2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Connor Adams
 */
public class OperatorJoystick extends Joystick{
    
    public OperatorJoystick( int port){
        super(port);
    }
    
    public boolean getDropIntakeButton(){
        return getRawButton(1);
    }
    
    public boolean getSuckBallButton(){
        return getRawButton(2);
    }
    
    public boolean getExaustBallButton(){
        return getRawButton(3);
    }
    
    public boolean getShootButton(){
        return getRawButton(6);
    }
    
    public boolean getStopCatapultButton(){
        return getRawButton(7);
    }
    
    public boolean getHPInboundButton(){
        return getRawButton(4);
    }
    public boolean get1114PassButton() {
        return getRawButton(5);
}




}