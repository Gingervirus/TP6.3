package com.example.armin.tp5.domain.Detention;

/**
 * Created by Armin on 2016-04-07.
 */
public class DetentionYes extends Detention{
    @Override
    public boolean handleRequest(String request) {
        if(request.equals("YES")){
            return true;
        }else{
            if (nextDetention!=null) {
                return nextDetention.handleRequest(request);
            }
            return false;
        }
    }
}