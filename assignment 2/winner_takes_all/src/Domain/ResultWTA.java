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
public class ResultWTA {
    private String resultStr;
    private ArrayList<ResultWTASingle> result = new ArrayList<ResultWTASingle>();

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public ArrayList<ResultWTASingle> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultWTASingle> result) {
        this.result = result;
    }
    
    
}
