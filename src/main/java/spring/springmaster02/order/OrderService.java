package spring.springmaster02.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
