# Gezi-Rehberim-Spring-MS
Gezi Rehberi, kullanıcıların gezilecek yerleri keşfetmesine olanak tanıyan bir uygulamadır. Kullanıcılar, yerleri favori olarak ekleyebilir, yorum yapabilir ve arama yapabilir.

## Mikro Hizmetler

- **PlaceService**: Yerleri listeleme, ekleme, silme ve güncelleme işlemlerini gerçekleştirir.
- **UserService**: Kullanıcı kayıt işlemlerini yönetir.
- **SearchService**: Kullanıcıların yerleri aramasına olanak tanır.
- **FavoritePlaceService**: Kullanıcıların yerleri favorilerine eklemelerine olanak tanır.
- **CommentService**: Kullanıcıların yerler hakkında yorum yapmalarını sağlar.

## Özellikler

- Kullanıcı kaydı
- Gezilecek yerleri favori olarak ekleme
- Yorum yapma
- Yer arama özelliği

## Kullanılan Teknolojiler

- **Spring Boot**
- **Spring Cloud**
- **Spring Security**
- **Kafka**
- **Elasticsearch**
- **PostgreSQL**
- **MongoDB**
- **SonarQube**
- **Grafana**
- **Docker**

---
# API Uç Noktaları

## PlaceController

- ```GET /api/place/getById/place/{id}```  
  Belirtilen ID'ye sahip yeri getirir.

- ```GET /api/place/getAllList/place```  
  Tüm yerlerin listesini getirir.

- ```GET /api/place/getList/PlaceWithPlaceCategory/{categoryId}```  
  Belirtilen kategori ID'sine sahip yerleri getirir.

- ```DELETE /api/place/delete/place/{id}```  
  Belirtilen ID'ye sahip yeri siler.

- ```POST /api/place/create/place```  
  Yeni bir yer oluşturur.

- ```PUT /api/place/update/place/{id}```  
  Belirtilen ID'ye sahip yeri günceller.

---

## PlaceCategoryController

- ```GET /api/placeCategory/getById/placeCategory/{id}```  
  Belirtilen ID'ye sahip kategori bilgilerini getirir.

- ```GET /api/placeCategory/listAll/placeCategory```  
  Tüm yer kategorilerinin listesini getirir.

- ```DELETE /api/placeCategory/delete/placeCategory/{id}```  
  Belirtilen ID'ye sahip kategoriyi siler.

- ```POST /api/placeCategory/create/placeCategory```  
  Yeni bir yer kategorisi oluşturur.

- ```PUT /api/placeCategory/update/placeCategory/{id}```  
  Belirtilen ID'ye sahip kategoriyi günceller.

---

## AuthController

- ```POST /api/auth/register```  
  Yeni bir kullanıcı kaydı oluşturur.

- ```POST /api/auth/login```  
  Kullanıcı giriş işlemi gerçekleştirir.

---

## UserController

- ```GET /api/users/getByIdUser/{id}```  
  Belirtilen ID'ye sahip kullanıcı bilgilerini getirir.

- ```GET /api/users/getAllUsers```  
  Tüm kullanıcıların listesini getirir.

---

## PlaceSearchController

- ```GET /place/search/listAll/place```  
  Tüm yerlerin listesini getirir.

- ```GET /place/search/search/placeName/{name}```  
  Belirtilen isimle eşleşen yerleri getirir.

---

## FavoriPlaceController

- ```GET /api/favoriPlace/getAll/favoritePlace```  
  Tüm favori yerlerin listesini getirir.

- ```GET /api/favoriPlace/getFavoriPlaceWithUser/{userId}```  
  Belirtilen kullanıcıya ait tüm favori yerleri getirir.

- ```POST /api/favoriPlace/create/favoriPlace/{placeId}/{userId}```  
  Belirtilen kullanıcı için favori bir yer oluşturur.

---

## CommentController

- ```POST /api/comment/create/comment```  
  Yeni bir yorum oluşturur.

- ```PUT /api/comment/update/comment/{commentId}```  
  Belirtilen ID'ye sahip mevcut bir yorumu günceller.


 