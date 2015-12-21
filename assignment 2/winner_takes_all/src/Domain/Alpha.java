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
public class Alpha {
    
    private ArrayList<Double> alpha=new ArrayList<>();

    public ArrayList<Double> getAlpha() {
        return alpha;
    }

    public void setAlpha(ArrayList<Double> alpha) {
        this.alpha = alpha;
    }
    
    /**
     * To print alpha to string.
     * @return alpha information
     */
    public String print()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<alpha.size();i++)
        {
            retval.append("A");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(alpha.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
}
