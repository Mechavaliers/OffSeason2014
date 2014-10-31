 
package ca.team4519.frc2014.subsystems;

import ca.team4519.lib.Subsystem;
import ca.team4519.frc2014.Constants;
import ca.team4519.lib.Loopable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Hashtable;


public class Intake extends Subsystem implements Loopable {
   
   private Victor rollerA = new Victor(Constants.intakeRollerA.getInt());
   private Victor rollerB = new Victor(Constants.intakeRollerB.getInt());
   private Solenoid intakeUp = new Solenoid(Constants.intakeUpSolenoidPort.getInt());
   private Solenoid intakeDown = new Solenoid(Constants.intakeDownSolenoidPort.getInt());
   
    double power = Constants.intakeSpeed.getDouble();
    private Object setIntakePosition;
   
    public void setRollerPower(double power) {
    rollerA.set(-power);
    rollerB.set(power);
    }
   
    public Intake(){
    super("Intake");
    intakeUp.set(true);
    intakeDown.set(false);
    }
    
    
  public void setIntakePosition(boolean up){
     intakeUp.set(up);
     intakeDown.set(!up);
    }   
   
 public boolean getIntakePosition(){
    if(intakeUp.get()== true && intakeDown.get()== false){
        }return true;  
    }

 public void suckBall(){
     rollerA.set(-power);
     rollerB.set(-power);
 }
 
public void exaustBall(){
    rollerA.set(power);
    rollerB.set(power);
    }
    
public void hpInbound(){
    intakeUp.set(false);
    intakeDown.set(true);
    rollerA.set(-power/2);
    rollerB.set(-power/2);
    } 
    
public void inboundSpitPass(){
    intakeUp.set(false);
    intakeDown.set(true);
    rollerA.set(power);
    rollerB.set(power);
    }
    
public Victor rollerASpeed(){
    return rollerA;
    }

public Victor rollerBSpeed(){
    return rollerB;
    }
    
     public Hashtable serialize() {
    Hashtable rollers = new Hashtable();
    Hashtable cylinders = new Hashtable();
    Hashtable encoders = new Hashtable();

    rollers.put("rollerA", new Double(rollerA.get()));
    rollers.put("rollerB", new Double(rollerB.get()));

   
    data.put("rollers", rollers);
       return data;
  }
    
    
    
     public void update(){
      SmartDashboard.putBoolean("intakePosition", getIntakePosition());
      SmartDashboard.putNumber("intakeRollerA-Speed", rollerA.get());
      SmartDashboard.putNumber("intakeRollerB-Speed", rollerB.get());
      super.update();
    
}

    
    
    
    
    
}
