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
public class Input {
    
    private ArrayList<Integer> input=new ArrayList<>();

    public ArrayList<Integer> getInput() {
        return input;
    }

    public void setInput(ArrayList<Integer> input) {
        this.input = input;
    }
    
    /**
     * To print input to string.
     * @return input information
     */
    public String print()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<input.size();i++)
        {
            retval.append("X");
            retval.append(i+1);
            retval.append(" : ");
            retval.append(input.get(i));
            retval.append("\n");
        }
        return retval.toString();
    }
}
