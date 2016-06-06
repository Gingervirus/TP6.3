package com.example.armin.tp5.domain.Detention;

/**
 * Created by Armin on 2016-04-07.
 */
public class DetentionNo extends Detention{
    @Override
    public boolean handleRequest(String request) {
        if(request.equals("NO")){
            return false;
        }else{
            if (nextDetention!=null) {
                return nextDetention.handleRequest(request);
            }
            return false;
        }
    }
}