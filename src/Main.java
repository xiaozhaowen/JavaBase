import com.mythread.BankCustomer;
import com.mythread.DeadLock;
import com.mythread.ProductAndConsumer;
import com.xiao.Person;

public class Main {

    static final  String appkey ="UniqueKey";

    public static void main(String[] args) {

//        BankCustomer.myTest(null);
//        DeadLock.test();
        ProductAndConsumer.test();

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