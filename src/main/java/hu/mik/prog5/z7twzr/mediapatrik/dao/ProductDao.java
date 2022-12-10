package hu.mik.prog5.z7twzr.mediapatrik.dao;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.ProductType;

import java.util.List;

public interface ProductDao extends CrudDao<Product, Long> {

    List<Product> findByType(ProductType type);

    boolean order(Long productId, Long userId);

    List<Product> findAllOrders(Long userId);

}
