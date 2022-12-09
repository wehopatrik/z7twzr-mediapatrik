package hu.mik.prog5.z7twzr.mediapatrik.dao;

import hu.mik.prog5.z7twzr.mediapatrik.dao.rowmapper.ProductRowMapper;
import hu.mik.prog5.z7twzr.mediapatrik.entity.Product;
import hu.mik.prog5.z7twzr.mediapatrik.entity.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductJdbcTemplate implements ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;

    @Override
    public Product create(Product object) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatementCreatorFactory psFactory = new PreparedStatementCreatorFactory(
                    "INSERT INTO product (name, price, image_name, type)", Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR);
            psFactory.setReturnGeneratedKeys(true);
            PreparedStatementCreator ps = psFactory.newPreparedStatementCreator(
                    List.of(object.getName(), object.getPrice(), object.getImageName(), object.getProductType().toString()));
            return ps.createPreparedStatement(connection);
        }, keyHolder);
        return this.findById(((Integer) keyHolder.getKeys().get("id")).longValue());
    }

    @Override
    public Product findById(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT p.id, p.name, p.price. p.image_name, p.type FROM product p WHERE p.id = ?",
                this.productRowMapper, id);
    }

    @Override
    public List<Product> findAll() {
        return this.jdbcTemplate.query("SELECT p.id, p.name, p.price, p.image_name, p.type FROM product p", this.productRowMapper);
    }

    @Override
    public Product update(Product object) {
        this.jdbcTemplate.update("UPDATE product p SET p.name = ?, p.price = ?, p.image_name = ?, p.type = ?", object.getName(),
                Integer.toString(object.getPrice()), object.getImageName(), object.getProductType().toString());
        return this.findById(object.getId());
    }

    @Override
    public boolean delete(Long id) {
        return this.jdbcTemplate.update("DELETE FROM product p WHERE p.id = ?", id) == 1;
    }

    @Override
    public List<Product> findByType(ProductType type) {
        return this.jdbcTemplate.query("SELECT p.id, p.name, p.price, p.image_name, p.type FROM product p WHERE p.type = ?",
                this.productRowMapper, type);
    }

}
