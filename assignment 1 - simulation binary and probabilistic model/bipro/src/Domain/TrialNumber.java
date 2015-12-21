/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Util.helper;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author d_frEak
 */
public class TrialNumber {
    
    private int size=1000;
    private ArrayList<Double> trial = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Double> getTrial() {
        return trial;
    }

    public void setTrial(ArrayList<Double> trial) {
        this.trial = trial;
    }
    
    public void generate()
    {
        trial.clear();
        Random randomGenerator = new Random();
        for(int i=0;i<size;i++)
        {
            trial.add(randomGenerator.nextDouble());
        }
    }
    
    /**
     * To print trial number to string.
     * @return trial number information
     */
    public String print()
    {
        StringBuilder retval=new StringBuilder();
        for(int i=0;i<trial.size();i++)
        {
            retval.append(trial.get(i));
            if(i%5==4)
            {
                retval.append("\n");
            }
            else
            {
                retval.append(" ");
            }
        }
        return retval.toString();
    }
    
    public void load(File file)
    {
        trial.clear();
        String[] splitStringRow=helper.load(file).split("\n");
        
        for(int i=0; i< splitStringRow.length;i++)
        {
            String[] splitString=splitStringRow[i].split(" ");
            for(int j=0; j< splitString.length;j++)
            {
                trial.add(Double.parseDouble(splitString[j]));
            }
        }
        size=trial.size();
    }
}
