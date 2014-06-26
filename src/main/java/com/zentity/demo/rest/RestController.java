package com.zentity.demo.rest;

import com.grum.geocalc.BoundingArea;
import com.grum.geocalc.DegreeCoordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;
import com.zentity.demo.domain.ATM;
import com.zentity.demo.repositories.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ATMRepository atmRepository;

    @RequestMapping("within_radius")
    public List<ATM> withinRadius(@RequestParam double standPointLatitude, @RequestParam double standPointLongitude, @RequestParam int radiusMeters, @RequestParam int limit) {
        radiusMeters = getCircumscribedRadius(radiusMeters);
        Point standPoint = new Point(new DegreeCoordinate(standPointLatitude), new DegreeCoordinate(standPointLongitude));
        BoundingArea boundingArea = EarthCalc.getBoundingArea(standPoint, radiusMeters);
        List<ATM> atms = atmRepository.findByLocLatCentroidBetweenAndLocLongCentroidBetween(
                Math.min(boundingArea.getNorthEast().getLatitude(), boundingArea.getSouthWest().getLatitude()),
                Math.max(boundingArea.getNorthEast().getLatitude(), boundingArea.getSouthWest().getLatitude()),
                Math.min(boundingArea.getNorthEast().getLongitude(), boundingArea.getSouthWest().getLongitude()),
                Math.max(boundingArea.getNorthEast().getLongitude(), boundingArea.getSouthWest().getLongitude()));
        return atms.stream()
                .sorted((a1, a2) -> getATMDistanceFromStandPoint(standPoint, a1).compareTo(getATMDistanceFromStandPoint(standPoint, a2)))
                .limit(limit)
                .collect(Collectors.toList());
    }

    private int getCircumscribedRadius(int radiusMeters) {
        return (int) (Math.sqrt(2) * radiusMeters);
    }

    @RequestMapping("in_rect")
    public List<ATM> inRect(@RequestParam double latitude1, @RequestParam double latitude2, @RequestParam double longitude1, @RequestParam double longitude2,
                            @RequestParam(required = false) Double standPointLatitude, @RequestParam(required = false) Double standPointLongitude,
                            @RequestParam int limit) {
        List<ATM> atms = atmRepository.findByLocLatCentroidBetweenAndLocLongCentroidBetween(
                Math.min(latitude1, latitude2),
                Math.max(latitude1, latitude2),
                Math.min(longitude1, longitude2),
                Math.max(longitude1, longitude2));
        if (standPointLatitude == null || standPointLongitude == null) {
            Collections.shuffle(atms);
            return atms.stream()
                    .limit(limit)
                    .collect(Collectors.toList());
        } else {
            Point standPoint = new Point(new DegreeCoordinate(standPointLatitude), new DegreeCoordinate(standPointLongitude));
            return atms.stream()
                    .sorted((a1, a2) -> getATMDistanceFromStandPoint(standPoint, a1).compareTo(getATMDistanceFromStandPoint(standPoint, a2)))
                    .limit(limit)
                    .collect(Collectors.toList());
        }
    }

    private Double getATMDistanceFromStandPoint(Point standPoint, ATM atm) {
        Point a1Loc = new Point(new DegreeCoordinate(atm.getLocLatCentroid()), new DegreeCoordinate(atm.getLocLongCentroid()));
        double distance = EarthCalc.getDistance(standPoint, a1Loc);
        atm.setDistanceMeters((int) distance);
        return distance;
    }
}
