package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sbt-selin-an on 18.04.2017.
 */
public class TankBot implements ServerListener {

    private GameController server;

    public TankBot(GameController server) {
        this.server = server;
    }

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        try {
            // place your code here
            // analise field
            // and perform action
             server.left(this);
             server.right(this);
             server.fire(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String getName() {
//        throw new RuntimeException("Place your command name here");
        return "Rx";
    }
}
