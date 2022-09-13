import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * java对象转换为json字符串
     */
    public static void objToJson() {
        //简单对象转换
        User user = new User("root", "123456");
        //调用toJSONString()
        String userJson = JSON.toJSONString(user);
        System.out.println("java类转换为json串：" + userJson);

        //集合转json串
        User user1 = new User("zhangsan", "123456");
        User user2 = new User("lisi", "000");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        //调用toJSONString()
        String usersjson = JSON.toJSONString(users);
        System.out.println("集合转json串：" + usersjson);

        //复杂java类转换对象
        UserGroup userGroup = new UserGroup("userGroup", users);
        //调用toJSONString()
        String userGroupJson = JSON.toJSONString(userGroup);
        System.out.println("复杂java类转换json串：" + userGroupJson);
    }

    /**
     * json字符串转为java类
     * 注：字符串中使用双引号需要转义 (" --> \"),这里使用的是单引号,易读性会好很多。
     * json串以“{}”包裹，转换为java类时，使用：parseObject();
     * json串以“[]”包裹，转换为java类时，使用：parseArray();
     */
    public static void jsonToObj(){
        /* json字符串转简单java对象
         * 字符串：{"password":"123456","username":"dmego"}
         */
        String jsonStr1 = "{'password':'123456','username':'ggf'}";
        // 调用parseObject()
        User user = JSON.parseObject(jsonStr1, User.class);
        System.out.println("json字符串转简单java对象:"+user.getUsername());

        /*
         * json字符串转List<Object>对象
         * 字符串：[{"password":"123123","username":"zhangsan"},
         *        {"password":"321321","username":"lisi"}]
         */
        String jsonStr2 = "[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]";
        // 调用parseArray()将字符串转为集合
        List<User> users = JSON.parseArray(jsonStr2, User.class);
        System.out.println("json字符串转List<Object>对象:"+users.toString());

        /*json字符串转复杂java对象
         * 字符串：{"name":"userGroup","users":[{"password":"123123","username":"zhangsan"},{"password":"321321","username":"lisi"}]}
         * */
        String jsonStr3 = "{'name':'userGroup','users':[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]}";
        UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
        System.out.println("json字符串转复杂java对象:"+userGroup.getName());
    }

    public static void main(String[] args){
//        objToJson();
        jsonToObj();
        System.out.println("hello");
    }
}