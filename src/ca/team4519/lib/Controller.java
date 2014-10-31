 
package ca.team4519.lib;

import ca.team4519.frc2014.MechaRobot;

public abstract class Controller extends MechaRobot implements Loopable {
  protected boolean enabled = false;
  
  public abstract void update();
  public abstract void reset();
  public abstract double getGoal();
  
  public void enable() {
    enabled = true;
  }
  
  public void disable() {
    enabled = false;
  }

  public boolean enabled() {
    return enabled;
  }
}