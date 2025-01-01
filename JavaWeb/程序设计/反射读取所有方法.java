import java.lang.reflect.Method;

public class Z1 {
    public static void main(String[] args) throws Exception {
        Class clazz = NoBug.class;
        NoBug noBug = (NoBug)clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent(Check.class))//如果需要
            m.invoke(noBug);
        }
    }
}
