package com.solvd.buildingCompany;

import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.enums.StyleQuality;
import com.solvd.buildingCompany.product.House;

import java.util.Random;

public class RandomHouse {
    public static House generateData() {
        Size size;
        int floors;
        String material;
        StyleQuality quality;
        boolean garden;
        int randomInt;

        Random random = new Random();

        randomInt = random.nextInt(3);
        if(randomInt == 0){
            size = Size.SMALL;
        } else if(randomInt == 1){
            size = Size.STANDARD;
        } else {
            size = Size.BIG;
        }

        floors = random.nextInt(3) + 1;

        randomInt = random.nextInt(3);
        if(randomInt == 0){
            material = "straw";
        } else if(randomInt == 1){
            material = "wood";
        } else {
            material = "brick";
        }

        randomInt = random.nextInt(3);
        if(randomInt == 0){
            quality = StyleQuality.MODEST;
        } else if(randomInt == 1){
            quality = StyleQuality.STANDARD;
        } else {
            quality = StyleQuality.LUXURIOUS;
        }

        garden = random.nextBoolean();
        return new House(size, floors, material, quality, garden);
    }
}
