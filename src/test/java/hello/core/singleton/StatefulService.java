package hello.core.singleton;

public class StatefulService {

    /* 전역변수로 선언하지말고
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);    //soutp 치면 생성됨
        this.price = price;
    }
     */

    // 지역번수로 선언해야 함
    public int order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);    //soutp 치면 생성됨
        return price;
    }

    /*
    public int getPrice(){
        return price;
    }
     */
}
