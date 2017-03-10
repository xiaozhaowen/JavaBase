import com.imooc.concurrent.Actor;

import com.imooc.concurrent.Stage;
import com.imooc.concurrent.daemon.DaemonClient;
import com.imooc.concurrent.train.ticket.SaleClient;
import com.imooc.concurrent.transform.EnergyClient;
import com.xiao.Person;



public class Main {

    static final  String appkey ="UniqueKey";

    public static void main(String[] args) {
//        Actor.test();
//        Stage.test();
//        EnergyClient.test();
//        SaleClient.test();
        DaemonClient.test();
    }


    static void mainTest(){

//        BankCustomer.myTest(null);
//        DeadLock.test();
//        ProductAndConsumer.test();
//        LiftOff.test();

//        System.out.println("Hello World!");
//
//        int myValue = 200;
//
//        changePrimitiveValue(myValue);
//
//        System.out.println(myValue);
//
//        System.out.println("引用传递");
//
//        Person person =new Person();
//        person.setAge(25);
//        person.setName("Jim");
//        System.out.println(person);
//        changeReferenceValue(person);
//        System.out.println("修改之后");
//        System.out.println(person);
//
//
//        System.out.println("引用传递重新赋值");
//        assignReferenceValue(person);
//        System.out.println(person);
    }

    static void changePrimitiveValue(int value){
        value =10;
    }

    static void changeReferenceValue( Person person){
         person.setName("Kobe");
    }

    static void assignReferenceValue( Person person){
        person = new Person();
        person.setName("中国人");
    }
}
