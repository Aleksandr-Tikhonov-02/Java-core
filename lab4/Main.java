package lab4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        try {
            Class<AnnotatedClass> c1 = AnnotatedClass.class;
            for (Method method:c1.getDeclaredMethods()) {
                if (method.isAnnotationPresent(TimesToInvoke.class)) {
                    if(Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);
                    }
                    int number = method.getAnnotation(TimesToInvoke.class).number();
                    Parameter[] parameters = method.getParameters();
                    if (parameters.length == 0) {
                        for (int i = 0; i < number; i++) {
                            method.invoke(c1);
                        }
                    } else if (parameters.length == 1 &&
                            method.getParameterTypes()[0].toString().equals(String.class.toString())) {
                        for (int i = 0; i < number; i++) {
                            method.invoke(c1, "Sasha");
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
