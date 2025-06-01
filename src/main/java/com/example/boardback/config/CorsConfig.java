
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**").allowedMethods("*") // 모든 매핑, 모든 메서드에 대해서  cors 허락
                    .allowedOrigins("*");
    }
}
