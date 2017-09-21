package com.laugues.cgm.part3.springboot.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.laugues.cgm.part3.springboot.security.dto.AuthenticationDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * The Token authentication service.
 */
class TokenAuthenticationService
{
    /**
     * The Expirationtime.
     */
    static final long EXPIRATIONTIME = 86400000;
    /**
     * The Secret.
     */
    static final String SECRET_KEY = "CgmSecretKey";
    /**
     * The Token prefix.
     */
    static final String TOKEN_PREFIX = "Bearer";
    /**
     * The Header string.
     */
    static final String HEADER_STRING = "Authorization";

    /**
     * The Mapper.
     */
    static final ObjectMapper mapper = new ObjectMapper();
    public static final String PRIVILIGES = "roles";

    /**
     * Add authentication.
     *
     * @param res            the res
     * @param authentication the authentication
     * @throws IOException the io exception
     */
    static void addAuthentication(HttpServletResponse res, Authentication authentication) throws IOException {
        HashMap<String, Object> claims = new HashMap<>();
        List<String> roles = getRoles(authentication);

        claims.put(PRIVILIGES, mapper.writeValueAsString(roles));
        String JWT = buildJwt(authentication, claims);

        AuthenticationDTO authenticationDTO = new AuthenticationDTO(JWT);

        res.getWriter().write(mapper.writeValueAsString(authenticationDTO));
    }

    /**
     * Gets authentication.
     *
     * @param request the request
     * @return the authentication
     * @throws IOException the io exception
     */
    static Authentication getAuthentication(HttpServletRequest request) throws IOException {
        Authentication result = null;
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            Claims claims = getClaims(token);

            String user = claims.getSubject();

            List<SimpleGrantedAuthority> authorities = getAuthorities(claims);

            if (user != null) {
                result = new UsernamePasswordAuthenticationToken(emptyList(), user, authorities);
            }
        }
        return result;
    }

    private static Claims getClaims(String token) {
        return Jwts.parser()
                   .setSigningKey(SECRET_KEY)
                   .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                   .getBody();
    }

    private static String buildJwt(Authentication authentication, HashMap<String, Object> claims) {
        return Jwts.builder()
                   .setClaims(claims)
                   .setSubject(authentication.getName())
                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                   .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                   .compact();
    }

    private static List<String> getRoles(Authentication authentication) {
        return authentication.getAuthorities()
                             .stream()
                             .map(GrantedAuthority::getAuthority)
                             .collect(Collectors.toList());
    }

    /**
     * Get a list of authorities from claims
     *
     * @param claims the claims to process
     * @return the list of authorities found
     * @throws IOException
     */
    private static List<SimpleGrantedAuthority> getAuthorities(Claims claims) throws IOException {
        List<String> grantedAuths = mapper.readValue(claims.get(PRIVILIGES).toString(),
                                                     TypeFactory.defaultInstance()
                                                                .constructParametricType(List.class, String.class));

        return grantedAuths
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

}