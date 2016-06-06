package com.example.armin.tp5.factories.Detention;


import com.example.armin.tp5.domain.Detention.Detention;
import com.example.armin.tp5.domain.Detention.DetentionNo;
import com.example.armin.tp5.domain.Detention.DetentionYes;


/**
 * Created by Armin on 2016-04-07.
 */
public class DetentionFactory {
    public static boolean getDetention(String req)
    {
        Detention chain = setUpChain();
        return chain.handleRequest(req);
    }

    public static Detention setUpChain()
    {
        Detention a = new DetentionYes();
        Detention b = new DetentionNo();

        a.setNextJob(b);
        return a;
    }
}
