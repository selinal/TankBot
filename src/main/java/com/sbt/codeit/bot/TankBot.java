package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class TankBot implements ServerListener {

    private GameController controller;
    private Character id;

    public TankBot(GameController controller) {
        this.controller = controller;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        //TODO Разместите свой код здесь. Пример вызова методов:
        controller.start(this); //начинаем ехать сразу и больше не останавливаемся
        controller.right(this); //поворачиваем направо
        controller.fire(this); //стреляем всегда, когда это возможно
    }

    public String getName() {
        throw new RuntimeException("Метод должен вернуть имя вашей команды");
    }

}
