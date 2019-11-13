package cn.gok;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @auther:huangjianxin
 * @create 2019-11-10 10:13
 * @description
 */
public class UserTest {


    //获取实例并创建对象方式一
    private static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass=Class.forName("cn.gok.User");
    User user=(User) aClass.newInstance();

        System.out.println(user);
}

    //获取实例并创建对象方式二
    private static void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class aClass=Class.forName("cn.gok.User");
        //获取构造器,可以调用有参构造器,此处获取的是对应类的无参构造器construct
     //   Constructor    constructor = aClass.getConstructor();


        //有参构造器类型，参数类型为String类型,一个就直接写String.class ，多个要写数组
        Constructor constructor=aClass.getConstructor(new Class[]{String.class});
        //创建对象
        User user=(User) constructor.newInstance("hjx");
        System.out.println(user);
    }


    public static void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass=Class.forName("cn.gok.User");
        User userz=(User) aClass.newInstance();
        Map<String,Object> datas=new HashMap<String, Object>();
        datas.put("username","hsf");
        Set<String> keys=datas.keySet();


        Field[] files = aClass.getDeclaredFields();
        for (Field filed:files){
            filed.setAccessible(true);
            String filedName=filed.getName();
            for (String key:keys){
                if(filedName.equals(key)){
                    filed.set(userz,datas.get(key));
                    break;
                }
            }
        }
        System.out.println(userz);
    }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //test1();
       // test2();
        test3();
    }
}
