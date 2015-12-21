/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author d_frEak
 */
public class Weight {
    
    private ArrayList<Integer> weight=new ArrayList<>();

    public ArrayList<Integer> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<Integer> weight) {
        this.weight = weight;
    }
    
    /**
     * To print weight to string.
     * @return weight information
     */
    public String print()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<weight.size();i++)
        {
            retval.append("W");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(weight.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
}
