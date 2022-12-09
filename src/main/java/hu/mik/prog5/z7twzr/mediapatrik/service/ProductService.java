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

}
