package spring.springmaster02.singleton;

public class StatelessService {
    private int price;  //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; // 여기가 문제!
    }
}
