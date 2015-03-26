package dk.thrysoee;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

@WebListener
public class GuiceWebListener extends GuiceResteasyBootstrapServletContextListener {

    @Override
    protected List<Module> getModules(ServletContext context) {

        return Arrays.asList(
                (Module) new ServletModule() {

                    @Override
                    protected void configureServlets() {

                        serve("/api/*").with(HttpServletDispatcher.class);
                        serve("/hello").with(HelloServlet.class);

                        bind(HttpServletDispatcher.class).in(Singleton.class);
                        bind(Greeter.class).to(GreeterImpl.class);
                        bind(HelloResource.class);

                    }
                });

    }

    @Override
    protected void withInjector(Injector injector) {

    }

}
