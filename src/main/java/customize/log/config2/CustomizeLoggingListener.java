package customize.log.config2;

import java.util.Collections;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;



public class CustomizeLoggingListener implements GenericApplicationListener {


  public void onApplicationEvent(ApplicationEvent event) {

    if (event instanceof ApplicationEnvironmentPreparedEvent) {
      ApplicationEnvironmentPreparedEvent e = (ApplicationEnvironmentPreparedEvent) event;
      ConfigurableEnvironment ee = e.getEnvironment();

      // ConfigurableEnvironment env
      MutablePropertySources propertySources = ee.getPropertySources();

      ClassPathResource resource = new ClassPathResource("classpath:haha.xml");

      // Properties properties = new Properties();
      // properties.setProperty(LoggingApplicationListener.CONFIG_PROPERTY, "classpath:haha.xml"));
      ee.getPropertySources().addFirst(new MapPropertySource("axxxa", Collections.singletonMap(LoggingApplicationListener.CONFIG_PROPERTY, "classpath:haha.xml")));
     
      
		}
  }

  public int getOrder(){
    return Ordered.HIGHEST_PRECEDENCE+18;
  }

  public boolean supportsEventType(ResolvableType eventType) {
    // TODO Auto-generated method stub
    return true;
  }
  
}
