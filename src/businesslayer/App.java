package businesslayer;


import businesslayer.model.OperationType;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){
//        List<OperationType> abc = new ArrayList<>();
//        abc.add(OperationType.SHAVE);
//        abc.add(OperationType.SHAVE);
//
//
//        System.out.println(abc);
//
//        abc.remove(OperationType.SHAVE);
//
//        System.out.println(abc);


        Mediator mediator = new Mediator();
        mediator.start();
    }

}
