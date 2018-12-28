package util;

/**
 * Created by 37269 on 2018/6/9.
 */
//@ConfigurationProperties("jwt.config")
public class JwtUtil {

    private String key;
    private long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

//    /**
//     *  签发 token
//     * @param id
//     * @param subject
//     * @param roles
//     * @return
//     */
//    public String createJWT(String id, String subject,String roles){
//        long now=System.currentTimeMillis();
//        long exp=now+ttl;
//
//        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
//                .setSubject(subject).setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, key)
//                .claim("roles",roles);
//        if(ttl>0){
//            jwtBuilder.setExpiration( new Date(exp));
//        }
//        String token = jwtBuilder.compact();
//        System.out.println(token);
//        return token;
//    }
//
//    /**
//     * 解析JWT
//     * @param token
//     * @return
//     */
//    public Claims parseJWT(String token){
//        return Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(token).getBody();
//    }


}
