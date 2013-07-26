import com.energizedwork.midcenturyipsum.IpsumGenerator
import org.ratpackframework.groovy.templating.*
import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
	modules {
		get(TemplatingModule).staticallyCompile = true
	}
	handlers {
		service(new IpsumGenerator()) {
			get {
				get(TemplateRenderer).render "index.html", ipsum: get(IpsumGenerator).generateText()
			}
		}
		assets "public"
	}
}
