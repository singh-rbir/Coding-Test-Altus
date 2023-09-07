import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Robot {
    //Please do not write any new code in this class
    //A brief description is provided within each method
    //describing its function

    public boolean isPathClear() {
        //returns true if no wall is in front of the robot
        //returns false if a wall is in front of the robot
        return true;
	}
    public void turnLeft() {
        //rotates the robot left by 90 degrees (counterclockwise)
    }
    public void moveForward() {
        //moves the robot forward one square
        //throws error if the robot hits a wall
    }
    public boolean hasExited() {
        //return true if the robot has exited the maze
        return true;
    }

    public static class Main {
        public static void main(String[] args) {
            Robot rob = new Robot();

            //Your code here
            class Point{
                Character move; // type of robot move (M: "move-forward", T: "turn") to keep track of Robot's moves
                int forks;  // no. or diversions that robot faces on it's way
                Point(Character m, int f){
                    move = m;
                    forks = f;
                }
            }

            Stack<Point> stack = new Stack<>(); //this structure will all the moves necessary to get to exit

            rob.moveForward();  // enter the maze

            while(!rob.hasExited()){
                if(rob.isPathClear()){
                    rob.moveForward();
                    stack.push(new Point('M', 0));
                } else{
                    rob.turnLeft();
                    if(rob.isPathClear()) { stack.push(new Point('L', 1));} // turn left
                    else {
                        rob.turnLeft();
                        rob.turnLeft();
                        stack.push(new Point('R', 1));
                    } // left was blocked, so turn right instead
                }
                // if robot meets dead end, backtrace
                rob.turnLeft();
                if (!rob.isPathClear()){
                    rob.turnLeft(); rob.turnLeft(); // turn 180 degrees
                    if(!rob.isPathClear()) { // backtrace
                        while (stack.peek().forks == 0) {
                            stack.pop();    // go back to the last fork location
                        }
                    }
                }
            }

            System.out.println(stack);  // prints all moves to exit

            // NOTE:
            // This is a general algorithm for finding maze exit (almost in pseudo-code fashion)
        }
    }
}


