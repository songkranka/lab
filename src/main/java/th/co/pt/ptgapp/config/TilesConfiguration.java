package th.co.pt.ptgapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        final String[] defs = {"WEB-INF/tiles/tiles.xml"};
        tilesConfigurer.setDefinitions(defs);
        return tilesConfigurer;
    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver() {
        final UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

}
