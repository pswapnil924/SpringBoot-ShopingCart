package com.tudip.dto;

public class CartItemDto {
    private int cartItemId;
    private CartTableDto cartTableDto;
    private ProductDto productDto;
    private int productQuantity;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public CartTableDto getCartTableDto() {
        return cartTableDto;
    }

    public void setCartTableDto(CartTableDto cartTableDto) {
        this.cartTableDto = cartTableDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
