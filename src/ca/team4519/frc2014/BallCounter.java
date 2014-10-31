package ca.team4519.frc2014;

public class BallCounter {

    private final String name;
    private final int maxCount;
    private int count;
    
    public BallCounter(String id, int max){
        this.name = id;
        maxCount = max;
        count = 0;
        
    }
    
    public void autonStart(){
        if(count == 0 ) count ++;
        if(count == 1);
        if(count == 2) count --;
    }
    
    public void moreBalls() {
        if(count < maxCount) count++;
    }
    
    public void lessBalls() {
        if(count > 0) count--;
    }
       
    public void noBalls() {
        count = 0;    
    }
    
    public int Value(){
        return count;
    }
    
    public String toString(){
        return name + ": " + count;
    }
    
}
