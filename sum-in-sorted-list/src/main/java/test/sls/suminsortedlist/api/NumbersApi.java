package test.sls.suminsortedlist.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.sls.suminsortedlist.api.model.SumCombinationRequest;
import test.sls.suminsortedlist.api.model.SumCombinationResponse;
import test.sls.suminsortedlist.service.NumbersService;

@RestController
@RequestMapping(path = "/numbers", consumes = "application/json")
public class NumbersApi {
    @Autowired
    private NumbersService numbersService;

    @ApiOperation(value = "get list of sorted numbers + a number and returns couple of numbers in list that sum of them eq the number")
    @RequestMapping(method = RequestMethod.POST, path = "/sorted/sum-combination")
    public @ResponseBody
    SumCombinationResponse findNumberCouples(@RequestBody SumCombinationRequest sumCombinationRequest){
        SumCombinationResponse sumCombinationResponse = numbersService.getAllCouplesEqTheNumber(sumCombinationRequest);
        return sumCombinationResponse;
    }

}
