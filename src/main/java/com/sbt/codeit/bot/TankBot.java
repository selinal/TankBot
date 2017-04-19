package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

public class TankBot implements ServerListener {

    private GameController controller;
    private Character id;

    private Random random = new Random();
    private int i = 0;

    public TankBot(GameController server) {
        this.server = server;
    public TankBot(GameController controller) {
        this.controller = controller;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        server.start(this);
        server.fire(this);
        i++;
        if(i % 5 != 0) {
            return;
        }
        switch (random.nextInt(4)){
            case 0:
                server.left(this);
                break;
            case 1:
                server.right(this);
                break;
            case 2:
                server.up(this);
                break;
            case 3:
                server.down(this);
                break;
        }
    }

    public String getName() {
        return "Team1";
    }
}
