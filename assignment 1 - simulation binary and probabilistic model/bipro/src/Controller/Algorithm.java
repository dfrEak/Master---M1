/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Alpha;
import Domain.Input;
import Domain.Result;
import Domain.TrialNumber;
import Domain.Weight;

/**
 *
 * @author d_frEak
 */
public class Algorithm {
    
    /**
     * To calculate p and n from param
     * @param input the input (1 or 0)
     * @param weight weight of each input
     * @param alpha alpha value that we are using
     * @param trial set of trials
     * @return result(p and n)
     */
    public static Result calculate(Input input, Weight weight, Alpha alpha, TrialNumber trial)
    {
        Result retval=new Result();
        
        //calculate s
        int s=0;
        for(int i=0;i<input.getInput().size();i++)
        {
            s+=input.getInput().get(i)*weight.getWeight().get(i);
        }
        
        for(int i=0;i<alpha.getAlpha().size();i++)
        {
            //calculate p=sigmoid(s)
            Double p=1/(1 + Math.pow( Math.E, -1*alpha.getAlpha().get(i)*s));
            retval.getP().add(p);
            
            //calculate n trial
            int n=0;
            for(int j=0;j<trial.getTrial().size();j++)
            {
                if(trial.getTrial().get(j)<=p)
                {
                    n++;
                }
            }
            retval.getN().add(n);
        }
        
        return retval;
    }
    
}
