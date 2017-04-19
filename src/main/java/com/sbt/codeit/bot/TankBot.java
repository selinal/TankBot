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

    public TankBot(GameController controller) {
        this.controller = controller;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        controller.start(this);
        controller.fire(this);
        i++;
        if(i % 5 != 0) {
            return;
        }
        switch (random.nextInt(4)){
            case 0:
                controller.left(this);
                break;
            case 1:
                controller.right(this);
                break;
            case 2:
                controller.up(this);
                break;
            case 3:
                controller.down(this);
                break;
        }
    }

    public String getName() {
        return "Team1";
    }
}
