package webstore.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*It's enough for spring to know that it's about spring security.
 *This and plus class SecurityConfig extends WebSecurityConfigurerAdapter.
 *Other configurations are not required.*/
public class SecurtityInit extends AbstractSecurityWebApplicationInitializer {
}