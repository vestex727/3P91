package Map;

import java.util.ArrayList;

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
        public Direction setDirection(Direction direction){this.direction = direction; return this.direction;}
        public TrafficElement getConnectingTo(){return connectingTo;}
        public TrafficElement getConnectingFrom(){return connectingFrom;}
}
