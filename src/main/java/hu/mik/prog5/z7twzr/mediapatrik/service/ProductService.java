package hu.mik.prog5.z7twzr.mediapatrik.service;

import hu.mik.prog5.z7twzr.mediapatrik.dao.ProductDao;
import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> findAll() {
        return this.productDao.findAll();
    }

    public Product findById(Long id) {
        return this.productDao.findById(id);
    }

    public boolean order(Long productId, Long userId) {
        return this.productDao.order(productId, userId);
    }

    public List<Product> findAllOrders(Long userId) {
        return this.productDao.findAllOrders(userId);
    }

}
