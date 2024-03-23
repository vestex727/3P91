package Map;

import java.util.ArrayList;

import static Map.Direction.*;
import static Map.TrafficElementType.LANE;


/**Lane extends the TrafficElement abstract class and gets a coordinate and queue of all vehicles on it as a result.
 * The lane also has a direction, and a length
 *
 */
public class Lane extends TrafficElement{
        double length;
        Direction direction;
        private TrafficElement connectingTo;
        private TrafficElement connectingFrom;

        /**Constructs a lane object
         *
         * @param pos   position of the lane
         * @param l     length of the lane
         */
        Lane(Coordinates pos, double l) {
                super(pos, LANE);
                length = l;
        }

        /**Gets the length of the lane
         *
         * @return
         */
        public double getLength(){return length;}

        /**Gets the direction of the lane
         *
         * @return
         */
        public Direction getDirection(){return direction;}

        /**Sets the direction of the lane
         *
         * @return direction of lane
         */
        public Direction setDirection(){
                if(connectingTo == null || connectingFrom == null) return null;
                return direction = findDirection(connectingFrom.getCoords(), connectingTo.getCoords());
        }

        /**Finds the direction of an edge (lane)
         *
         * @param start Start coords of the lane
         * @param end   End coords of the lane
         * @return      Direction of the
         */
        private Direction findDirection(Coordinates start, Coordinates end){return valueOf(getNS(start.y, end.y) + getEW(start.x, end.x));}

        private String getNS(double y1, double y2){
                double temp = y2-y1;
                if(temp > 0) return "NORTH";
                if(temp < 0) return "SOUTH";
                return "";
        }

        private String getEW(double x1, double x2){
                double temp = x2-x1;
                if(temp > 0) return "EAST";
                if(temp < 0) return "WEST";
                return "";
        }

        //public Direction setDirection(Direction d){return direction = d;}

        public TrafficElement getConnectingTo(){return connectingTo;}
        public TrafficElement setConnectingTo(TrafficElement to){return connectingTo = to;}

        public TrafficElement getConnectingFrom(){return connectingFrom;}
}
