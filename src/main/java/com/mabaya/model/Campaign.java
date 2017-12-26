package com.mabaya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "campaigns")
public class Campaign {

    private static final int VALIDITY_PERIOD = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Product> products;
    private String name;
    private BigDecimal bid;
    private ProductCategory category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static Campaign createCampaign(String name,
                                          LocalDateTime startDate,
                                          BigDecimal bid,
                                          ProductCategory category,
                                          List<Product> products) {
        return new Campaign()
                .setName(name)
                .setStartDate(startDate)
                .setEndDate(startDate.plusDays(VALIDITY_PERIOD))
                .setBid(bid)
                .setCategory(category)
                .setProducts(products);
    }

    public long getId() {
        return id;
    }

    public Campaign setId(long id) {
        this.id = id;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Campaign setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public String getName() {
        return name;
    }

    public Campaign setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public Campaign setBid(BigDecimal bid) {
        this.bid = bid;
        return this;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Campaign setCategory(ProductCategory category) {
        this.category = category;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Campaign setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Campaign setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }
}
