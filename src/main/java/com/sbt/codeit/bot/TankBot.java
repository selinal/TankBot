package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TankBot implements ServerListener {

    private static GameController server;
    private static ServerListener client;

    private int i = 0;

    public static void main(String... args) {
        try {
            TankBot tankBot = new TankBot();
            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
            server = (GameController) registry.lookup(STUB_NAME);
            client = (ServerListener) UnicastRemoteObject.exportObject(tankBot, 0);
            server.register(client, getName());
            server.start(client);
            synchronized (tankBot) {
                tankBot.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String getName(){
        //place your command name here
//        throw new RuntimeException("Place your command name here");
        return "HARMA";
    }

    public void update(ArrayList<ArrayList<Character>> field) {
        try {
            // place your code here
            //analise field
            // and perform action
//            server.left(client);
//            server.right(client);
//            server.fire(client);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
