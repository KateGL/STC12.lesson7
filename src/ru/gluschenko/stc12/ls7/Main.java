package ru.gluschenko.stc12.ls7;

import ru.gluschenko.stc12.ls3.MathActions;
import ru.gluschenko.stc12.ls3.MathBox;
import ru.gluschenko.stc12.ls3.PrintActions;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Integer[] initArray = new Integer[10];
        initArray[0] = 7;
        initArray[1] = 1;
        initArray[2] = 2;
        initArray[3] = 2;
        initArray[4] = 19;
        initArray[5] = null;
        initArray[6] = 72;
        initArray[7] = 67;
        initArray[8] = 15;
        initArray[9] = -3;
        MathBox mathBox = new MathBox(initArray);
        mathBox.printList();
        MathBoxProxy proxy = new MathBoxProxy(mathBox);

        Object proxyBox = Proxy.newProxyInstance(MathBoxProxy.class.getClassLoader(),
                new Class[]{MathActions.class, PrintActions.class}, proxy);

        System.out.println(((MathActions)proxyBox).splitter(3));
        System.out.println(((MathActions)proxyBox).summator());
        mathBox.printList();
        ((PrintActions)proxyBox).printList();

    }
}
