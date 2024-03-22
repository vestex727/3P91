package Vehicles;

import java.util.ArrayList;

/**Reputation of item
 * History of reputation
 *
 */
public class Reputation {
    private double niceness;
    private ArrayList<Double> repHistory;

    /**Updates current reputation value
     *
     * @param newRep
     * @return
     */
    public double updateReputation(double newRep){
        niceness = newRep;
        repHistory.add(niceness);
        return niceness;
    }

    /**Gets and returns the reputation
     *
     * @return reputation value */
    public double getReputation(){return niceness;}

    /**Gets and returns reputation history
     *
     * @return repHistory
     */
    public ArrayList<Double> getRepHistory(){return repHistory;}
}
