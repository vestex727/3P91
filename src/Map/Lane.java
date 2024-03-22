package Map;

import java.util.ArrayList;

import static Map.TrafficElementType.LANE;

public class Lane extends TrafficElement{
        double length;
        Direction direction;
        private TrafficElement connectingTo;
        private TrafficElement connectingFrom;

        /**Constructs a lane object
         *
         * @param pos   position of the lane
         * @param l     length of the lane
         * @param d     direction of the lane
         */
        Lane(Coordinates pos, double l, Direction d) {
                super(pos, LANE);
                length = l;
                direction = d;
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
        public TrafficElement getConnectingTo(){return connectingTo;}
        public TrafficElement getConnectingFrom(){return connectingFrom;}
}
