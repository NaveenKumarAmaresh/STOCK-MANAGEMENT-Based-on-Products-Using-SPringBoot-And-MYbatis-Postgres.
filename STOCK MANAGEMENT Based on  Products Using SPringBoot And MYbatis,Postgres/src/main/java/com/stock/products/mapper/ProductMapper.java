 package com.stock.products.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.stock.products.model.Product;

@Mapper
@Repository
public interface ProductMapper {
		 

 	@Select(" Select * from products WHERE is_deleted=false ")
	 List<Product> findAll();
	
	@Select("Select * from products WHERE (id=#{id} AND is_deleted=false) ")
	 public  Product findById(Integer id);
	
	@Insert(" insert into products(name,price,specs,avail_qty,created_at,updated_at,is_deleted) "
		+ "values(#{name},#{price},#{specs},#{availQty},#{createdAt},#{updatedAt},false) ")
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(Product product);
	
	@Update("update products set name=#{name},price=#{price},specs=#{specs},avail_qty=#{availQty},updated_at=#{updatedAt} WHERE id=#{id}")
	public void update(Product product);
	
	@Update("UPDATE products SET is_deleted=true WHERE id=#{id}")
	public void deleteById( Integer id);
	
	@Select("select id,name,price,specs from products where id=#{id}")
	public  Product byId(Integer id);
}