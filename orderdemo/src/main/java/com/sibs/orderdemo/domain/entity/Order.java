package com.sibs.orderdemo.domain.entity;

import com.sibs.orderdemo.domain.exception.DomainException;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "OrderItem")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private Item orderItem;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "creationDate")
    private Instant creationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(){}

    public Order(int quantity, final Item orderItem, final User user) {
        this.quantity = quantity;
        this.orderStatus = OrderStatus.CREATED;
        this.orderItem = orderItem;
        this.user = user;
        this.creationDate = Instant.now();
        //this.itemList = new HashSet<>(Collections.singletonList(new Item(itemName, itemId)));
    }

    public void complete() {
        validateStatus();
        this.orderStatus = OrderStatus.COMPLETED;
    }

//    public void addOrder(final Item item) {
//        validateStatus();
//        validateItem(item);
//        itemList.add(item);
//    }

//    public void removeOrder(long id) {
//        validateStatus();
//        final Item item = getItemsList(id);
//        itemList.remove(item);
//
//    }

//    private Item getItemsList(long id) {
//        return itemList.stream().filter(
//                        item -> item.getId() == id
//                ).findFirst()
//                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist"));
//    }

    public void validateStatus() {
        if (OrderStatus.COMPLETED.equals(orderStatus)) {
            throw new DomainException("The order is in completed status.");
        }
    }

    private void validateItem(final Item item) {
        if (item == null) {
            throw new DomainException("Item cannot be null.");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Item orderItem) {
        this.orderItem = orderItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && quantity == order.quantity && Objects.equals(orderItem, order.orderItem) && Objects.equals(user, order.user) && Objects.equals(creationDate, order.creationDate) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItem, quantity, user, creationDate, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItem=" + orderItem +
                ", quantity=" + quantity +
                ", user=" + user +
                ", creationDate=" + creationDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
