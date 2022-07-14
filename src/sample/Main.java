package sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TextContainer tx = new TextContainer("Hello World! Hello Java!");

        Class<?> cls = tx.getClass();
        String pathForFile = "";
        if (cls.isAnnotationPresent(SaveTo.class)) {
            SaveTo sv = cls.getAnnotation(SaveTo.class);
            pathForFile = sv.pathForFile();
        }

        Method[] mt = cls.getDeclaredMethods();

        for (Method method : mt) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(tx, pathForFile);
            }
        }
    }
}
