/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Controller.Algorithm;
import Domain.*;
import View.MainView;

/**
 *
 * @author d_frEak
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //assignment 1
        MainView tes= new MainView();
        tes.setVisible(true);
        
        /*
        ///////////////////////////PREVIOUS CMD TEST
        Input input=new Input();
        Weight weight=new Weight();
        Alpha alpha=new Alpha();
        TrialNumber trial=new TrialNumber();
        Result result=new Result();
        
        //setting input
        input.getInput().add(0);
        input.getInput().add(1);
        input.getInput().add(0);
        input.getInput().add(0);
        input.getInput().add(1);
        input.getInput().add(1);
        input.getInput().add(1);
        input.getInput().add(1);
        System.out.println("input");
        System.out.println(input.print());
        
        //setting weight
        weight.getWeight().add(-1);
        weight.getWeight().add(2);
        weight.getWeight().add(-2);
        weight.getWeight().add(2);
        weight.getWeight().add(3);
        weight.getWeight().add(-3);
        weight.getWeight().add(1);
        weight.getWeight().add(2);
        System.out.println("weight");
        System.out.println(weight.print());
        
        //setting alpha
        alpha.getAlpha().add(0.5);
        alpha.getAlpha().add(1.0);
        alpha.getAlpha().add(2.0);
        alpha.getAlpha().add(5.0);
        System.out.println("alpha");
        System.out.println(alpha.print());
        
        System.out.println("trial");
        System.out.println("start generate");
        trial.generate();
        System.out.println("finish generate");
        System.out.println(trial.print());
        
        System.out.println("==============algorithm==============");
        System.out.println("start calculate");
        result=Algorithm.calculate(input, weight, alpha, trial);
        System.out.println("finish calculate");
        System.out.println(result.print());
        */
        
        //assignment 2_1
//        assignment2_1 tes=new assignment2_1();
//        tes.setVisible(true);
    }
    
}
