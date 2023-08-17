package com.teknopar.northwind.repository.abstracts;

import com.teknopar.northwind.model.concretes.Product;
import com.teknopar.northwind.model.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    /*
    * fonksiyonlarımızın başına getBy veya findBy gibi bir isimlendirme getirirsek
    * JPA tarafından bu fonksiyonlar hazır olarak getiriliyor
    * Jpa getBy gördüğü zaman bir where oşulu yazması gerektiğini anlıyor
    * Önemli olan isimlendirme kurallarına uymak
    * */

    Product getByProductName(String productName);

    //select * from prodcuts where product_name='x' and category_id=y
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // burada categorynin hangi alanını getireceğini kurduğumuz ilişkiden anlıyor.Tablolarda category_id üzerinden ilişki kurduk

    //select * from prodcuts where product_name='x' or category_id=y
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); //İki kolondan birine göre data getiriyoruz

    //select * from products where category_id in(1,2,3,4)
    List<Product> getByCategoryIn(List<Integer> categories);


    List<Product> getByProductNameContains(String productName); //ürün ismi içeriyorsa sorgusunu yerine getirir

    List<Product> getByProductNameStartsWith(String productName); //ürün ismi şunla başlıyorsa sorgusunu yerine getirir


    /*
    * jpql sorgusu
    * //From'dan sonra veritabanındaki tablo adını değil entity adını veriyoruz.
    * Parametre vermek için ='den sonra : koyuyoruz.
    * Atama yaptığımız ilk değişkenler bizim tablo sınıfımızda olan değişken isimleri.
    * :='den sonraki kısımlar da aşağoıdaki fonksiyonda yazan parametrelerdir.
    * category.categoryId bu ifadeyi yazmamızın sebebi Product sınıfı içerisinde categoryId'yi silmiş olmamız.
    * Category sınıfını id'sine ulaşmak için category.categoryId yaptık.
    * Biz sorguda From Product dediğim için bu ifade Product sınıfındaki tanımladığımız Category sınıfının categoryId'si
    * */
    @Query("From Product where productName=:productName and category.categoryId=:categoryId") //tüm alanları çektiğimiz için From ifadesini kullandık
    List<Product> getByNameAndCategory(String productName, int categoryId);


    /*
    * her zaman ana tablodan gitmek bizim için daha iyi olacaktır.OnetoMany de ana tablo one tarafının temsil ettiği tablodur.
    * Belirli alanları döndüreceğimiz için select ifadesini kullandık
    * dtos paket ismini yazmamızın sebebi çekmek istediğimiz alanları o pakette bulunan sınıfa atamak istememiz
    * new yazmamızın sebebi com.teknopar.northwind.model.dtos.ProductWithCategoryDto alanındaki constructoeu çalıştırması için
    * Normalde sql ifadesinde join işleminde on ifadesi kullanırdık.
    * burada category tablosu ile product tablosunu inner join olarak ayarladığımız için yazmamıza gerek kalmadı
    * aşağıdaki sorgu sayesinde parantez içine yazılmış olan alanları ProductWithCategoryDto sınıfına aktarmış olduk
    * */
    @Query("Select new com.teknopar.northwind.model.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
