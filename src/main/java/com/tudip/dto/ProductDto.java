package com.tudip.dto;

public class ProductDto {

    private int productId;
    private String productName;
    private int productInStock;
    private boolean isProductOutOfStock;
    private float productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(int productInStock) {
        this.productInStock = productInStock;
    }

    public boolean isProductOutOfStock() {
        return isProductOutOfStock;
    }

    public void setProductOutOfStock(boolean productOutOfStock) {
        isProductOutOfStock = productOutOfStock;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
