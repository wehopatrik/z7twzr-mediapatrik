package hu.mik.prog5.z7twzr.mediapatrik.dao.rowmapper;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.ProductType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setImageName(rs.getString("image_name"));
        product.setPrice(rs.getInt("price"));
        product.setProductType(ProductType.valueOf(rs.getString("type")));
        return product;
    }

}
