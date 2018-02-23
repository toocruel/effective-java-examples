package org.effectivejava.examples.chapter01;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by sty on 2018/2/23.
 */
public enum  OperateTypeEnum {

    ADD("增加"){
        @Override
        public void getInfo(){
            System.out.println("这个是add");
        }
        public void getPrint(){
            System.out.println("add");
        }
    },DELETE("删除"),UPDATE("更新"),QUERY("查询");

    public void getInfo(){
        System.out.println("我是原始方法，我可以被重写");
    }

    private String enumDesc;

    OperateTypeEnum(String enumDesc) {
        this.enumDesc = enumDesc;
    }

    public String getEnumDesc() {
        return enumDesc;
    }

    public void setEnumDesc(String enumDesc) {
        this.enumDesc = enumDesc;
    }



    public static void testEnumMethod(){

        Class clazz = OperateTypeEnum.class;
        Class clazzSuper = clazz.getSuperclass();
        if(clazzSuper != null)
            System.out.println(clazzSuper.getName());

    }

    public static void testEnumMethod2(){

        Class clazz = OperateTypeEnum.class;
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        System.out.println(Arrays.toString(OperateTypeEnum.values()));
        //循环所有的枚举类型
        for(OperateTypeEnum val : OperateTypeEnum.values()){
            System.out.println(val.getEnumDesc());
        }
    }

    public static void testEnumMethod3(){

        System.out.println(Arrays.toString(OperateTypeEnum.values()));
        //循环所有的枚举类型
        for(OperateTypeEnum val : OperateTypeEnum.values()){
            System.out.println(val.getEnumDesc());
        }
    }

    public static void testSwitchEnum() {
        putSwitchEnum(OperateTypeEnum.DELETE);
    }

    public static void putSwitchEnum(OperateTypeEnum enumSwitch) {

        switch (enumSwitch) {
            case ADD:
                System.out.println("这个是add方法");
                break;
            case DELETE:
                System.out.println("这个是delete方法");
                break;
            case UPDATE:
                System.out.println("这个是update方法");
                break;
            default:
                System.out.println("这个是query方法");
                break;
        }
    }

    public static void testEnumCustom(){
        OperateTypeEnum enumTest = ADD;
        enumTest.ADD.UPDATE.getInfo();
    }

    public static void main(String[] args) {
//        testEnumMethod();
//        testEnumMethod2();
//        testEnumMethod3();
//        testSwitchEnum();

        for (OperateTypeEnum test : OperateTypeEnum.values()) {
            System.out.println(test.name()+" "+test.ordinal());
        }

        EnumMap<OperateTypeEnum, String> enumMap = new EnumMap<OperateTypeEnum, String>(OperateTypeEnum.class);
        enumMap.put(OperateTypeEnum.DELETE, "dddddddddddddd");
        enumMap.put(OperateTypeEnum.UPDATE, "uuuuuuuuuuuuuu");
        for (Map.Entry<OperateTypeEnum, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getValue() + entry.getKey().getEnumDesc());
        }

//        EnumSet<OperateTypeEnum> enumSets = EnumSet.of(OperateTypeEnum.DELETE);
//        EnumSet<OperateTypeEnum> enumSets = EnumSet.allOf(OperateTypeEnum.class);
//        EnumSet<OperateTypeEnum> enumSets = EnumSet.range(OperateTypeEnum.DELETE,OperateTypeEnum.UPDATE);
        EnumSet<OperateTypeEnum> enumSet = EnumSet.noneOf(OperateTypeEnum.class);
        enumSet.add(OperateTypeEnum.DELETE);
        enumSet.add(OperateTypeEnum.UPDATE);
        for (Iterator<OperateTypeEnum> it = enumSet.iterator(); it.hasNext();) {
            System.out.println(it.next().getEnumDesc());
        }
        for (OperateTypeEnum enumTest : enumSet) {
            System.out.println(enumTest.getEnumDesc() + "  ..... ");
        }

        EnumSet<OperateTypeEnum> enumSets = EnumSet.copyOf(enumSet);
    }
}
