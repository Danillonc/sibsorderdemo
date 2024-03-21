package com.sibs.orderdemo.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "StockMovement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "creationDate")
    private Instant creationDate;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    public StockMovement(){}
    public StockMovement(int quantity, Item item){
        this.quantity = quantity;
        this.item = item;
        this.creationDate = Instant.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockMovement that = (StockMovement) o;
        return id == that.id && quantity == that.quantity && Objects.equals(creationDate, that.creationDate) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, quantity, item);
    }

    @Override
    public String toString() {
        return "StockMovement{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", quantity=" + quantity +
                ", item=" + item +
                '}';
    }
}
