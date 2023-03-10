package com.spring.demo.springperfromancetestingdataservice1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class VehicleDetailsController {

    @GetMapping ("/customer/{vehicleId}/vehicleDetails")
    public VehicleDetails getContractDetails (@PathVariable String vehicleId) throws InterruptedException {

        Random r = new Random ();
        int multiplier = r.nextInt (5) * 1000;
        System.out.println ("Delay is: " + multiplier);
        Thread.sleep (multiplier);


        return createContractDetails (vehicleId);

    }

    private VehicleDetails createContractDetails (String vehicleId) {


        List<VehicleDetails> list = new ArrayList<> ();
        list.add (new VehicleDetails ("501", "Auto 1", "45HJK"));
        list.add (new VehicleDetails ("608", "Renault", "45GHj"));
        list.add (new VehicleDetails ("997", "Lima", "46GFHJ"));

        return list.stream ().filter (c -> vehicleId.equals (c.customerId ())).findAny ().orElse (null);
    }

}
