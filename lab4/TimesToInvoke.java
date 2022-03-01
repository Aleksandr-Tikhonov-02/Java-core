package lab4;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimesToInvoke {
    int number() default 1;
}

/* return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(i -> i * i)
                .toList();*/
