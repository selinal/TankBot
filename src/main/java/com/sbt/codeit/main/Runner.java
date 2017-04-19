package com.sbt.codeit.main;

import com.sbt.codeit.bot.TankBot;
import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

/**
 * Подключение бота к серверу.
 * ИЗМЕНЯЯ КЛАСС, ВЫ СОГЛАШАЕТЕСЬ РЕШАТЬ ВСЕ ВОЗНИКАЮЩИЕ ПРОБЛЕМЫ САМОСТОЯТЕЛЬНО
 */
public class Runner {

    private static final int PORT = 2017;
    private static final String STUB_NAME = "GameController";

    private static Registry registry;
    private static GameController server;
    private static ServerListener client;

    public static void main(String... args) throws Exception {
        registry = LocateRegistry.getRegistry(PORT);
        server = (GameController) registry.lookup(STUB_NAME);
        TankBot tankBot = new TankBot(server);
        client = (ServerListener) UnicastRemoteObject.exportObject(tankBot, 0);
        Character id = server.register(client, tankBot.getName());
        tankBot.setId(id);
        while(true) {
            checkConnection();
        }
    }

    private static void checkConnection() {
        try {
            registry.lookup(STUB_NAME);
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex) {
            System.err.println("Connection closed");
            System.exit(0);
        }
    }

}