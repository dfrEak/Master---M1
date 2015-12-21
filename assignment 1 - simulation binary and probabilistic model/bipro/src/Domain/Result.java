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
public class Result {
    
    private ArrayList<Double> p=new ArrayList<>();
    private ArrayList<Integer> n=new ArrayList<>();

    public ArrayList<Double> getP() {
        return p;
    }

    public void setP(ArrayList<Double> p) {
        this.p = p;
    }

    public ArrayList<Integer> getN() {
        return n;
    }

    public void setN(ArrayList<Integer> n) {
        this.n = n;
    }
    
    /**
     * To print result(p and n) to string.
     * @return result information
     */
    public String print()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<p.size();i++)
        {
            retval.append("P , N");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(p.get(i));
            retval.append(" , ");
            retval.append(n.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
    
    /**
     * To print result p to string.
     * @return result p information
     */
    public String printP()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<p.size();i++)
        {
            retval.append("P");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(p.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
    
    /**
     * To print result n to string.
     * @return result n information
     */
    public String printN()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<n.size();i++)
        {
            retval.append("N");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(n.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
}
