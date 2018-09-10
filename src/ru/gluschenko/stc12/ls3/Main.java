package ru.gluschenko.stc12.ls3;

import java.util.Arrays;

public class Main {

    /***
     * Код для теста класса MathBox ДЗ 3
     * @param args
     */
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

        System.out.println("initArray:"+ Arrays.toString(initArray));
        System.out.println("------------------------");
        MathBox mathBox = new MathBox(initArray);
        mathBox.printList();

        System.out.println("------------------------");
        System.out.println("MathBox summator:"+ mathBox.summator());
        System.out.println("MathBox splitter 0:"+ mathBox.splitter(0));
        System.out.println("MathBox splitter 1:"+ mathBox.splitter(1));
        System.out.println("MathBox splitter 2:"+ mathBox.splitter(2));

        System.out.println("------------------------");
        System.out.println("MathBox remove null:"+ mathBox.remove(null));
        mathBox.printList();
        System.out.println("MathBox remove 188:"+ mathBox.remove(188));
        mathBox.printList();
        System.out.println("MathBox remove 15:"+ mathBox.remove(15));
        mathBox.printList();

        System.out.println("------------------------");
        System.out.println("MathBox toString:"+ mathBox.toString());
        System.out.println("MathBox hashCode:"+ mathBox.hashCode());
        System.out.println("MathBox equals self:"+ mathBox.equals(mathBox));

        MathBox mathBox2 = new MathBox(initArray);
        mathBox2.remove(15);
        mathBox2.printList();
        System.out.println("MathBox equals same:"+ mathBox.equals(mathBox2));
        System.out.println("MathBox hashCode:"+ mathBox2.hashCode());

        initArray[1] = 77;
        MathBox mathBox3 = new MathBox(initArray);
        mathBox3.printList();
        System.out.println("MathBox equals diff:"+ mathBox.equals(mathBox3));
        System.out.println("MathBox hashCode:"+ mathBox3.hashCode());

    }
}
