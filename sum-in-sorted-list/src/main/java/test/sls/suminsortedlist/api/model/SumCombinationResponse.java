package test.sls.suminsortedlist.api.model;

import java.util.Map;

public class SumCombinationResponse {
    private Map<Integer, Integer> numberCouples;

    public SumCombinationResponse(Map<Integer, Integer> numberCouples) {
        this.numberCouples = numberCouples;
    }

    public Map<Integer, Integer> getNumberCouples() {
        return numberCouples;
    }

    public void setNumberCouples(Map<Integer, Integer> numberCouples) {
        this.numberCouples = numberCouples;
    }
}
