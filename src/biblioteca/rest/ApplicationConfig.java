package biblioteca.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")  
public class ApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> sets = new HashSet();
		sets.add(CrossOriginFilter.class);
		sets.add(LivroRest.class);
		return sets;
	}
}
