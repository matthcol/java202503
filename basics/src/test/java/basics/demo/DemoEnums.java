package basics.demo;

import basics.TrafficLight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import java.text.MessageFormat;

public class DemoEnums {

    @Test
    void demoTrafficLight(){
        TrafficLight trafficLight = TrafficLight.RED;
        System.out.println(trafficLight);

        String color = "GREEN";
        trafficLight = TrafficLight.valueOf(color);
        System.out.println(trafficLight);

        trafficLight = TrafficLight.values()[2];
        System.out.println("Couleur #2 : " + trafficLight);

        System.out.println();
        System.out.println("Nombre de couleurs : " + TrafficLight.values().length);
        for (TrafficLight tl: TrafficLight.values()){
            System.out.println(MessageFormat.format(
                    " - Couleur: {0} ; position : {1}",
                    tl,
                    tl.ordinal()
            ));
        }
    }

    @ParameterizedTest
    @EnumSource(TrafficLight.class)
    @NullSource
    void demoTrafficLight2(TrafficLight trafficLight){
        System.out.println("Couleur : " + trafficLight);
        System.out.println(trafficLight.ordinal()); // => NullPointerException
        switch (trafficLight){
            case RED -> System.out.println("STOP !!");
            case GREEN -> System.out.println("GO");
            case ORANGE -> System.out.println("You may STOP");
            case null -> System.out.println("Feu en panne");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "RED, 101",
            "GREEN, 222",
            "ORANGE, 321",
            ", 678",  // 1ère valeur nulle
            "," // 2 valeurs nulles
    })
    // NB: Integer peut être null, pas int
    void demoTrafficLight(TrafficLight trafficLight, Integer x){
        System.out.println(MessageFormat.format(
                "Couleur : {0} ; x : {1}",
                trafficLight, x
        ));
    }

}
