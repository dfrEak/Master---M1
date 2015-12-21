/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author d_frEak
 */
public class Node {
    
    private Weight weight=new Weight();
    private double threshold;

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
    
    public void print()
    {
        System.out.println(weight.print());
        System.out.println("Threshold="+threshold);
    }
    
}
