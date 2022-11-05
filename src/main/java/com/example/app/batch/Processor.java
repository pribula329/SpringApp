package com.example.app.batch;

import com.example.app.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> WORK_POSITIONS =
            new HashMap<>();
    private static final Map<String, String> RATING =
            new HashMap<>();

    public Processor() {
        WORK_POSITIONS.put("1", "CEO");
        WORK_POSITIONS.put("2", "Developer");
        WORK_POSITIONS.put("3", "Manager");
        WORK_POSITIONS.put("4", "Project Manager");
        WORK_POSITIONS.put("5", "Tester");

        RATING.put("GOOD", "***");
        RATING.put("EXCELLENT", "*****");
        RATING.put("VERY_GOOD", "****");
        RATING.put("BAD", "*");
        RATING.put("AVERAGE", "**");
    }

    @Override
    public User process(User user) throws Exception {
        //years worked
        String positionCode = user.getPosition();
        String position = WORK_POSITIONS.get(positionCode);

        //rating code
        String ratingCode = user.getRating();
        String rating = RATING.get(ratingCode);

        //compute fee
        Double fee = user.getFee();
        Integer yearsWorked = user.getYearsWorked();

        user.setFee(computeFee(fee, yearsWorked));
        user.setRating(rating);
        user.setPosition(position);
        user.setTime(new Date());

        return user;
    }

    private double computeFee(Double fee, Integer yearsWorked){
        return fee * yearsWorked * 0.5;
    }
}
