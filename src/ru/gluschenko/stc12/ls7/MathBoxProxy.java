package ru.gluschenko.stc12.ls7;

import ru.gluschenko.stc12.ls3.ClearData;
import ru.gluschenko.stc12.ls3.Logged;
import ru.gluschenko.stc12.ls3.MathBox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxProxy implements InvocationHandler {
    private MathBox box;


    public MathBoxProxy(MathBox box) {
        this.box = box;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Method mth = this.box.getClass().getMethod(method.getName(),method.getParameterTypes());

        if(mth.getAnnotation(ClearData.class) != null){
            System.out.println("CLEAR LIST");
            this.box.clearList();
        }

        if(this.box.getClass().getAnnotation(Logged.class) != null){
            long startTime = System.currentTimeMillis();
            System.out.println("----We call method " + method.getName());
            Object result = method.invoke(this.box, args);
            System.out.println("----with time " + (System.currentTimeMillis() - startTime));
            return result;
        }
        return method.invoke(this.box, args);
    }
}
