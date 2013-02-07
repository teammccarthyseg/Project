
import javaclient3.PlayerClient;
import javaclient3.PlayerException;
import javaclient3.Position2DInterface;
import javaclient3.RangerInterface;
import javaclient3.structures.PlayerConstants;
import javaclient3.structures.PlayerPose2d;
import javaclient3.structures.position2d.PlayerPosition2dCmdPos;


public class MainApp {
    /** 
     Robot control application.
     */
    public static void main(String[] args) {
        PlayerClient robot=null;
        Position2DInterface pos2D=null;
        RangerInterface sonar=null;

	
        try {
            robot = new PlayerClient("localhost", 6665);
            pos2D = robot.requestInterfacePosition2D(0,PlayerConstants.PLAYER_OPEN_MODE);
            sonar = robot.requestInterfaceRanger(0,PlayerConstants.PLAYER_OPEN_MODE);
 
            
        } catch (PlayerException e) {
            System.err.println("Robot: Error connecting to Player!\n>>>" + e.toString());
            System.exit(1);
        }

        robot.runThreaded(-1,-1);
        pos2D.setSpeed(0.2,0);

    }
}
