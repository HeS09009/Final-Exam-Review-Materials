import java.util.*;
import java.util.Map.Entry;

public class MapTest {

    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new HashMap();
        //往Map中添加元素
        map.put("US", "America");
        map.put("IT", "挨踢");
        map.put("IT", "Italian");
        map.put("CN", "China");
        //打印输出
        System.out.println("Map的大小：" + map.size());
        System.out.println(map);
        //map集合的遍历
        //方法1：取出所有的key，根据每个key取出对应的value
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("======================================");
        //方法2：遍历每一个键值对
        Set<Entry<String, String>> mapSet = map.entrySet();
        Iterator<Entry<String, String>> iter = mapSet.iterator();
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //判断方法
        System.out.println("是否为空：" + map.isEmpty());
        System.out.println("是否存在某个键值：" + map.containsKey("IT"));
        System.out.println("是否存在某个值：" + map.containsValue("挨踢"));

        //查询
        System.out.println("简称为IT的国家全称：" + map.get("IT"));
        System.out.println("所有简称" + map.keySet());
        System.out.println("所有全称" + map.values());

        //删除
        String remove = map.remove("IT");
        System.out.println("被删除的值：" + remove);
        map.clear();//清空Map

    }

}
