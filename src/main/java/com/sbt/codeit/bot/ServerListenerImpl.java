package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by sbt-selin-an on 18.04.2017.
 */
public class ServerListenerImpl implements ServerListener {

    private GameController server;

    public ServerListenerImpl(GameController server) {
        this.server=server;
    }

    //    private static ServerListener client;

/*    public ServerListenerImpl(String name) {
        try {
            Registry registry = LocateRegistry.getRegistry(ServerListener.HOST, ServerListener.PORT);
            server = (GameController) registry.lookup(ServerListener.STUB_NAME);
            client = (ServerListener) UnicastRemoteObject.exportObject(tankBot, 0);
            server.register(client, name);
            server.start(client);
            synchronized (tankBot) {
                tankBot.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }*/

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        try {
            // place your code here
            // analise field
            // and perform action
             server.left(this);
            // server.right(client);
            // server.fire(client);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
