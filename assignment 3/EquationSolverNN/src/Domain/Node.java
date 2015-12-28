/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.Random;

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
    
    
    /**
     * To calculate binary deterministic
     * @param input input
     * @param node node properties
     * @return output 0 or 1
     */
    public static int calculateBiDet(Input input, Node node)
    {
        int retval=1;
        int total=0;
        for(int i=0;i<input.getInput().size();i++)
        {
            total+=input.getInput().get(i)*node.getWeight().getWeight().get(i);
        }
        if(total<node.getThreshold())
        {
            retval=0;
        }
        return retval;
    }
    
    /**
     * To calculate single WTA Deterministic (1 step only)
     * @param input the input
     * @param weight the weight for this node
     * @param threshold the threshold of this node
     * @param turn which node that take current turn
     * @return result set of input, e, and s
     */
    public static ResultWTASingle calculateSingleDet(Input input, ArrayList<Weight> weight, ArrayList<Double> threshold, double constant, int turn)
    {
        ResultWTASingle retval=new ResultWTASingle();
        double s=0;
        double e=0;
        
        for(int i=0; i<input.getInput().size(); i++)
        {
            // check if it is the changed input or not
            if(i!=turn)
            {
                s+=input.getInput().get(i)*weight.get(turn).getWeight().get(i);
            }
            // previous ver.
//           e+=input.getInput().get(i);
        }
        
        Input temp=new Input();
        temp.getInput().addAll(input.getInput());
        // change input for next iteration
        if(s>=threshold.get(turn))
        {
            temp.getInput().set(turn, 1);
        }
        else
        {
            temp.getInput().set(turn, 0);
        }
        
        // calculate energy
        // previous ver.
//        e=(int) Math.pow(e-1, 2);
        e=CalculateE(input, weight, threshold, constant);
        retval.setInput(temp);
        retval.setS(s);
        retval.setE(e);
        return retval;
    }
    
    /**
     * To calculate winner takes all process
     * @param input all init value of each node
     * @param weight set of weight of each node (n x n)
     * @param threshold threshold of all node
     * @param constant the constant,
     * @return set of all result set and a string
     */
    public static ResultWTA calculateDet(Input input, ArrayList<Weight> weight, ArrayList<Double> threshold, double constant)
    {
        ResultWTA retval=new ResultWTA();
        StringBuilder str=new StringBuilder("Result Deterministic:\n");
        // turn start from 0
        int turn=0;
        ResultWTASingle result_single=new ResultWTASingle();
        // loop till input result same with the prev input
        boolean loop=true;
        int sameval=0;
        // add first looping because need to check all node
        while(loop||sameval<input.getInput().size())
        {
           result_single=calculateSingleDet(input, weight, threshold, constant, turn);
           retval.getResult().add(result_single);
           
           // add to string
           str.append("--").append("(");
           for(int i=0;i<input.getInput().size()-1;i++)
           {
               str.append(input.getInput().get(i)).append(",");
           }
           str.append(input.getInput().get(input.getInput().size()-1));
           str.append(")");
           str.append(" - E=").append(result_single.getE()).append("\n");
           str.append("=================================================\n");
           str.append("-change node ").append(turn+1).append("\n");
           str.append("--S=").append(result_single.getS()).append("\n");
           
           // compare input
           if(inputCompare(input, result_single.getInput()))
           {
               // stop looping
               loop=false;
               sameval++;
           }
           else
           {
               loop=true;
               sameval=0;
               // change input
               input=new Input();
               input.getInput().addAll(result_single.getInput().getInput());
           }
           // change turn
           turn++;
           if(turn>=input.getInput().size())
           {
               turn=0;
           }
        }
        // last node
        str.append("--").append("(");
           for(int i=0;i<input.getInput().size()-1;i++)
           {
               str.append(input.getInput().get(i)).append(",");
           }
        str.append(input.getInput().get(input.getInput().size()-1));
        str.append(")");
        str.append(" - E=").append(result_single.getE()).append("\n");
        str.append("=================================================\n");
        str.append("-change node ").append(turn+1).append("\n");
        str.append("--S=").append(result_single.getS()).append("\n");
        // last node from result
        str.append("--").append("(");
           for(int i=0;i<result_single.getInput().getInput().size()-1;i++)
           {
               str.append(result_single.getInput().getInput().get(i)).append(",");
           }
        str.append(result_single.getInput().getInput().get(input.getInput().size()-1));
        str.append(")");
        str.append(" - E=");
        str.append(CalculateE(result_single.getInput(), weight, threshold, constant));
        str.append("\n");
        str.append("=================================================\n");
        str.append("=======================END=======================\n");
        str.append("=================================================\n");
        retval.setResultStr(str.toString());
        
        return retval;
    }
    
    /**
     * To calculate single WTA Probabilistic (1 step only)
     * @param input the input
     * @param weight the weight for this node
     * @param threshold the threshold of this node
     * @param alpha alpha value
     * @param constant constant value
     * @param turn which node that take current turn
     * @return result set of input, e, and s
     */
    public static ResultWTASingle calculateSinglePro(Input input, ArrayList<Weight> weight, ArrayList<Double> threshold, double constant, double alpha, int turn)
    {
        ResultWTASingle retval=new ResultWTASingle();
        double s=0;
        double e=0;
        
        for(int i=0; i<input.getInput().size(); i++)
        {
            // check if it is the changed input or not
            if(i!=turn)
            {
                s+=input.getInput().get(i)*weight.get(turn).getWeight().get(i);
            }
        }
        
        // calculate p=sigmoid(s)
        double p=1/(1 + Math.pow( Math.E, -1*alpha*(s-threshold.get(turn))));
        
        Input temp=new Input();
        temp.getInput().addAll(input.getInput());
        Random randomGenerator = new Random();
        double r=randomGenerator.nextDouble();
        System.out.println("p: "+p);
        System.out.println("r: "+r);
        // change input for next iteration
        if(r<=p)
        {
            temp.getInput().set(turn, 1);
        }
        else
        {
            temp.getInput().set(turn, 0);
        }
        
        // calculate energy
        // previous ver.
//        e=(int) Math.pow(e-1, 2);
        e=CalculateE(input, weight, threshold, constant);
        retval.setInput(temp);
        retval.setS(s);
        retval.setE(e);
        return retval;
    }
    
    /**
     * To calculate winner takes all process
     * @param input all init value of each node
     * @param weight set of weight of each node (n x n)
     * @param threshold threshold of all node
     * @param alpha alpha value
     * @return set of all result set and a string
     */
    public static ResultWTA calculatePro(Input input, ArrayList<Weight> weight, ArrayList<Double> threshold, double constant, double alpha)
    {
        ResultWTA retval=new ResultWTA();
        StringBuilder str=new StringBuilder("Result Probabilistic:\n");
        // turn start from 0
        int turn=0;
        ResultWTASingle result_single=new ResultWTASingle();
        // loop till input result same with the prev input
        boolean loop=true;
        int sameval=0;
        // add first looping because need to check all node
        while(loop||sameval<input.getInput().size())
        {
           result_single=calculateSinglePro(input, weight, threshold, constant, alpha, turn);
           retval.getResult().add(result_single);
           
           // add to string
           str.append("--").append("(");
           for(int i=0;i<input.getInput().size()-1;i++)
           {
               str.append(input.getInput().get(i)).append(",");
           }
           str.append(input.getInput().get(input.getInput().size()-1));
           str.append(")");
           str.append(" - E=").append(result_single.getE()).append("\n");
           str.append("=================================================\n");
           str.append("-change node ").append(turn+1).append("\n");
           str.append("--S=").append(result_single.getS()).append("\n");
           
           // compare input
           if(inputCompare(input, result_single.getInput()))
           {
               // stop looping
               loop=false;
               sameval++;
           }
           else
           {
               loop=true;
               sameval=0;
               // change input
               input=new Input();
               input.getInput().addAll(result_single.getInput().getInput());
           }
           // change turn
           turn++;
           if(turn>=input.getInput().size())
           {
               turn=0;
           }
        }
        // last node
        str.append("--").append("(");
           for(int i=0;i<input.getInput().size()-1;i++)
           {
               str.append(input.getInput().get(i)).append(",");
           }
        str.append(input.getInput().get(input.getInput().size()-1));
        str.append(")");
        str.append(" - E=").append(result_single.getE()).append("\n");
        str.append("=================================================\n");
        str.append("-change node ").append(turn+1).append("\n");
        str.append("--S=").append(result_single.getS()).append("\n");
        // last node from result
        str.append("--").append("(");
           for(int i=0;i<result_single.getInput().getInput().size()-1;i++)
           {
               str.append(result_single.getInput().getInput().get(i)).append(",");
           }
        str.append(result_single.getInput().getInput().get(input.getInput().size()-1));
        str.append(")");
        str.append(" - E=");
        str.append(CalculateE(result_single.getInput(), weight, threshold, alpha));
        str.append("\n");
        str.append("=================================================\n");
        str.append("=======================END=======================\n");
        str.append("=================================================\n");
        retval.setResultStr(str.toString());
        
        return retval;
    }
    
    
    /**
     * To compare 2 input same or not
     * @param input1 first input
     * @param input2 second input
     * @return boolean same or not
     */
    private static boolean inputCompare(Input input1, Input input2)
    {
        for(int i=0;i<input1.getInput().size();i++)
        {
            if(input1.getInput().get(i)!=input2.getInput().get(i))
                return false;
        }
        return true;
    }
    
    /**
     * To generate weight
     * @param weight
     * @param count
     * @return 
     */
    public static ArrayList<Weight> generateWeight(int weight, int count)
    {
        ArrayList<Weight> retval=new ArrayList<>();
        Weight w=new Weight();
        for(int i=0;i<count;i++)
        {
            w=new Weight();
            for(int j=0;j<count;j++)
            {
                if(i==j)
                {
                    w.getWeight().add(0);
                }else{
                    w.getWeight().add(weight);
                }   
            }
            retval.add(w);
        }
        return retval;
    }
    
    /**
     * 
     * @param threshold
     * @param count
     * @return 
     */
    public static ArrayList<Double> generateThreshold(double threshold, int count)
    {
        ArrayList<Double> retval=new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            retval.add(threshold);
        }
        return retval;
    }
    
    public static double CalculateE(Input input, ArrayList<Weight> weight, ArrayList<Double> threshold, double constant)
    {
        double retval=0;
        for(int i=0;i<input.getInput().size();i++)
        {
            for(int j=0;j<input.getInput().size();j++)
            {
                retval+=weight.get(i).getWeight().get(j)*input.getInput().get(i)*input.getInput().get(j);
            }
        }
        retval=(-0.5)*retval;
        for(int i=0;i<input.getInput().size();i++)
        {
            retval+=threshold.get(i)*input.getInput().get(i);
        }
        retval+=constant;
        return retval;
    }
}
