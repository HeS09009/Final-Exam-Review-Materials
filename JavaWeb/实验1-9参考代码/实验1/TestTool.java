
package ex1;

import java.lang.reflect.Method;

public class TestTool {

    public static void main(String[] args) throws Exception {
        
        Class clazz = NoBug.class;
        NoBug noBug = (NoBug)clazz.newInstance();//【代码三】通过clazz创建名为noBug的NoBug实例对象
        Method[] methods = clazz.getDeclaredMethods(); //【代码四】获取NoBug类声明的方法
             
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(Check.class)) { // 只有被@Check 标注过的方法才进行测试
                try {
                    m.invoke(noBug);
                } catch (Exception e) {
					   errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getName());
                    log.append("\n");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n");
                }
            }
        }
        //获取被测试的类名（不包含包名）
        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errornum);
        log.append(" error.");
        // 生成测试报告
        System.out.println(log.toString());
    }
}


