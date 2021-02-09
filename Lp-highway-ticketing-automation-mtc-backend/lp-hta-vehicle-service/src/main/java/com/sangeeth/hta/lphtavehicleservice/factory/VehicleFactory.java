package com.sangeeth.hta.lphtavehicleservice.factory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sangeeth.hta.commons.models.vehicle.*;

import java.util.Locale;

/**
 * @author dtsangeeth
 * @created 10 / 02 / 2021
 * @project lp-hta-vehicle-service
 */
public class VehicleFactory {

    public static Gson gson = new Gson();

    public static Vehicle getVehicle(String type , String vehicle ){

        if (type.equalsIgnoreCase("car")){
            return gson.fromJson(vehicle, Car.class);
        }else if(type.equalsIgnoreCase("jeep")){
            return gson.fromJson(vehicle, Jeep.class);
        }else if(type.equalsIgnoreCase("van")){
            return gson.fromJson(vehicle, Van.class);
        }else if(type.equalsIgnoreCase("cab")){
            return gson.fromJson(vehicle, Cab.class);
        }else if(type.equalsIgnoreCase("bus")){
            return gson.fromJson(vehicle, Bus.class);
        }else if(type.equalsIgnoreCase("lorry")){
            return gson.fromJson(vehicle, Lorry.class);
        }else if(type.equalsIgnoreCase("truck")){
            return gson.fromJson(vehicle, Truck.class);
        }
        return null;

    }
}
