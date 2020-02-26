package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidationService {

    public void validatePrice(Product product) throws ProductValidationException {
        if (product.getPrice().compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new ProductValidationException("ОШИБКА! Цена не может быть меньше 0.");
        }
    }

    public void validateDiscount(Product product) throws ProductValidationException {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(1)) >= 1) {
            throw new ProductValidationException("ОШИБКА! Скидка не может быть больше 1 (100%).");
        }
    }

    public void validateName(Product product) throws ProductValidationException {
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("ОШИБКА! Название не может быть меньше 3 или больше 32 символов.");
        }
    }


}

