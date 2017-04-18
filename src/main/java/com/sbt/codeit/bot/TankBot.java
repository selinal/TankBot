package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TankBot  {

    private static GameController server;
    private static ServerListener client;

    public static void main(String... args) {
        try {
            Registry registry = LocateRegistry.getRegistry(ServerListener.HOST, ServerListener.PORT);
            server = (GameController) registry.lookup(ServerListener.STUB_NAME);

            ServerListener tankBot = new ServerListenerImpl(server);

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
        return "HHHSA";
    }



}
