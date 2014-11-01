package ca.team4519.frc2014.actions;

public class DriveDistance extends Action {
    
    double distance;
    boolean doStop;
    double heading;
    double newHeading;
    double currentHeading;
    double currentDistance;
    boolean targetHeading;
    
  public DriveDistance(double distance, double heading){
        
        this.distance = distance;
        this.heading = heading;
    }
    
    public boolean execute() {
        return false;
    }

    public void init() {
         driveBase.resetEncoders();
         driveBase.resetGyro();
         
         currentHeading = driveBase.smartAngle();
         currentDistance = driveBase.getAverageDistance();
         
         
     if(currentHeading == heading || currentHeading < heading + 5 || currentHeading > heading - 5 ){
         driveBase.setLeftRightPower(0, 0);
         targetHeading =true;
       }else if(currentHeading != heading && currentHeading < heading){
         driveBase.setLeftRightPower(0.5, -0.5);
         targetHeading = false;
       }else if (currentHeading != heading && currentHeading > heading){
          driveBase.setLeftRightPower(-0.5, 0.5);
          targetHeading = false;
     }
     driveBase.resetEncoders();
     if(currentDistance == distance || currentDistance < distance + (1/12) || currentDistance > distance + (1/12)){
         driveBase.setLeftRightPower(0, 0);
     }else if((currentDistance != distance) && targetHeading){
         driveBase.setLeftRightPower(1, 1);
     }
     
    }

    public void done() {
        driveBase.setLeftRightPower(0, 0);
    }
}
