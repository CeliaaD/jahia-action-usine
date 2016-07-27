package actions;

import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jahia.bin.Action;
import org.jahia.bin.ActionResult;
import org.jahia.services.content.JCRNodeIteratorWrapper;
import org.jahia.services.content.JCRNodeWrapper;
import org.jahia.services.content.JCRSessionWrapper;
import org.jahia.services.render.RenderContext;
import org.jahia.services.render.Resource;
import org.jahia.services.render.URLResolver;
import org.jahia.services.sites.JahiaSite;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class BulkAddPages extends Action {

	@Override
	public ActionResult doExecute(HttpServletRequest req,
			RenderContext renderContext, Resource resource,
			JCRSessionWrapper session, Map<String, List<String>> parameters,
			URLResolver urlResolver) throws Exception {
		
		org.jahia.registries.ServicesRegistry s = org.jahia.registries.ServicesRegistry.getInstance();
		
		System.out.println(s.getJahiaSitesService().getSiteByKey("usineagences").toString());
		
		JahiaSite site = s.getJahiaSitesService().getSiteByKey("usineagences");
		
		
		JCRNodeWrapper node = s.getJahiaSitesService().getSiteByKey("usineagences", session).getHome();
		
		JCRNodeIteratorWrapper it = node.getNodes();
		
		while (it.hasNext()) System.out.println(it.nextNode().toString());
		
		System.out.println("Added");
		node.addNode("agence_niort", "jnt:page");
		
		JCRNodeIteratorWrapper it2 = node.getNodes();
		
		while (it2.hasNext()) System.out.println(it2.nextNode().toString());
		
		
		//s.getJahiaSitesService().getSitesNames();

		
		System.out.println("In the action!");
		//System.out.println(renderContext.getSite().toString());
		//System.out.println(renderContext.get);
		//System.out.print
		//renderContext.getSite().getHome().addNode("agence_niort", "jnt:page");
		return new ActionResult(HttpServletResponse.SC_OK, "/sites/usineagences/home");
	}

}
