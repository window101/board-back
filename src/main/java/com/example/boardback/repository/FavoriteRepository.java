

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk>{
    // favoritepk.java에서 primary key 생성 (현재 이 테이블은 외래키만 2개 있고 pk가 없음)

    
}
