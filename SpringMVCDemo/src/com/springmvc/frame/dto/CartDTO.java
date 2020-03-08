package com.springmvc.frame.dto;

import com.springmvc.frame.service.CartService;

public class CartDTO {

	//得到CartServie对象
	private CartService cartService;

	public CartDTO() {
		super();
		
	}

	public CartDTO(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@Override
	public String toString() {
		return "CartDTO [cartService=" + cartService + "]";
	}

}
