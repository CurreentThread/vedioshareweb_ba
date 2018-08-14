package com.vsw.common.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * token生成
 *  @author luomouren
 */
public class TokenUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 签名秘钥
     */
    public static final String SECRET = "guangYuan";

    /**
     * 生成token
     * @param id 一般传入userName
     * @return
     */
    public static String createJwtToken(String id){
        String issuer = "www.vsw.com";
        String subject = "vedioshare@163.com";
        long ttlMillis = System.currentTimeMillis(); 
        return createJwtToken(id, issuer, subject, ttlMillis);
    }

    /**
     * 生成Token
     * 
     * @param id
     *            编号
     * @param issuer
     *            该JWT的签发者，是否使用是可选的
     * @param subject
     *            该JWT所面向的用户，是否使用是可选的；
     * @param ttlMillis
     *            签发时间
     * @return token String
     */
    public static String createJwtToken(String id, String issuer, String subject, long ttlMillis) {

        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 通过秘钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
            .setIssuedAt(now)
            .setSubject(subject)
            .setIssuer(issuer)
            .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();

    }

    // Sample method to validate and read the JWT
    public static Claims parseJWT(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
            .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static void main(String[] args) {
//
        String accessToken = TokenUtils.createJwtToken("13588030816");

        String accessToken1 = TokenUtils.createJwtToken("admin");
        System.out.println(accessToken);

        System.out.println(StringUtils.pathEquals(accessToken,TokenUtils.createJwtToken("admin")));

//        try {
            Claims claims = TokenUtils.parseJWT(accessToken);
        Claims claims1 = TokenUtils.parseJWT(accessToken1);
                System.out.println(claims.getId());
        System.out.println(claims1.getId());

//
//        }finally {
//            System.out.println("不存在");
//        }

    }
}