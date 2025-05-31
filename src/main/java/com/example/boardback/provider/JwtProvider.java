
@Component
public class JwtProvider {
    private String secretKey = "S3cr3tK3y";
    public String create(String email) {
        //email 받아서 jwt 만듬
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS)); // 1시간짜리

        String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.ES256, secretKey)
                    .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
                    .compact();
        return jwt;
    }    
    public String validate(String jwt) { // 검증
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey)
                    .parseClaimJws(jwt).getBody();
        }catch(Exception exception)
            exception.printStackTrace();
            return null;
        }
        return claims.getSubject();


}
