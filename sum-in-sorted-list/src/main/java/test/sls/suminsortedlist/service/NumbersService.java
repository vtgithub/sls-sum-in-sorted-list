package test.sls.suminsortedlist.service;

import org.springframework.stereotype.Service;
import test.sls.suminsortedlist.api.model.SumCombinationRequest;
import test.sls.suminsortedlist.api.model.SumCombinationResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NumbersService {
    public SumCombinationResponse getAllCouplesEqTheNumber(SumCombinationRequest sumCombinationRequest) {
        int nearestIndexToSum = getNearestIndexToSum(sumCombinationRequest.getSortedNumberList(), sumCombinationRequest.getSum());
        Map<Integer, Integer> coupleOfNumbers = getCoupleOfNumbersInSortedList(
                0, nearestIndexToSum, sumCombinationRequest.getSortedNumberList(), sumCombinationRequest.getSum());
        return new SumCombinationResponse(coupleOfNumbers);
    }

    //---------- helpers
    // returns nearest number index (in sorted list) to the sum
    private int getNearestIndexToSum(List<Integer> sortedNumberList, int sum) {
        int index =  sortedNumberList.size()-1;
        for (int i = sortedNumberList.size()-1; i >= 0 ; i--) {
            if (sortedNumberList.get(i).intValue() < sum){
                index = i;
                break;
            }
        }
        return index;
    }
    // returns map of target numbers
    private Map<Integer, Integer> getCoupleOfNumbersInSortedList(int lowerIndex, int upperIndex, List<Integer> sortedNumberList, int sum) {
        Map<Integer, Integer> coupleOfNumbers = new HashMap<>();
        boolean reasonableCouplesExists = true;
        int lowerDistance, upperDistance;
        while (reasonableCouplesExists && (lowerIndex < upperIndex)){
            if ((sortedNumberList.get(lowerIndex).intValue() + sortedNumberList.get(upperIndex).intValue()) < sum)
                reasonableCouplesExists = false;
            else {
                if ((sortedNumberList.get(lowerIndex).intValue() + sortedNumberList.get(upperIndex).intValue()) == sum){
                    coupleOfNumbers.put(sortedNumberList.get(lowerIndex).intValue(), sortedNumberList.get(upperIndex).intValue());
                }
                lowerDistance = sortedNumberList.get(lowerIndex+1).intValue() - sortedNumberList.get(lowerIndex).intValue();
                upperDistance = sortedNumberList.get(upperIndex).intValue() - sortedNumberList.get(upperIndex-1).intValue();
                if (lowerDistance == upperDistance ){
                    lowerIndex++;
                    upperIndex--;
                }else if ((lowerDistance > upperDistance) ){
                    upperIndex--;
                } else if ((lowerDistance < upperDistance) ){
                    lowerIndex++;
                }
            }
        }
        return coupleOfNumbers;
    }
}
