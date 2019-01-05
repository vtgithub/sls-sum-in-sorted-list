package test.sls.suminsortedlist.api.model;

import java.util.List;

public class SumCombinationRequest {
    private List<Integer> sortedNumberList;
    private int sum;

    public List<Integer> getSortedNumberList() {
        return sortedNumberList;
    }

    public void setSortedNumberList(List<Integer> sortedNumberList) {
        this.sortedNumberList = sortedNumberList;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
