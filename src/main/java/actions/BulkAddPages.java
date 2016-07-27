package actions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jahia.bin.Action;
import org.jahia.bin.ActionResult;
import org.jahia.services.content.JCRNodeIteratorWrapper;
import org.jahia.services.content.JCRNodeWrapper;
import org.jahia.services.content.JCRPublicationService;
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
		
		
		
        
		
		//******************Ajout des noeuds
		
		org.jahia.registries.ServicesRegistry s = org.jahia.registries.ServicesRegistry.getInstance();
		JahiaSite site = s.getJahiaSitesService().getSiteByKey("usineagences");
		
		//System.out.println(s.getJahiaSitesService().getSiteByKey("usineagences").toString());
		
		JCRNodeWrapper node = s.getJahiaSitesService().getSiteByKey("usineagences", session).getHome();
		
		JCRNodeIteratorWrapper it = node.getNodes();
		while (it.hasNext()) System.out.println(it.nextNode().toString());
		
		/*JCRNodeWrapper titre = node.getNode("header").addNode("intro", "siteusiner:titre");
		titre.setProperty("Titre", "ceci est un titre");*/
		JCRNodeWrapper newnode = node.addNode("agence_niort", "jnt:page");
		newnode.setProperty("j:templateName", "home");
		newnode.setProperty("jcr:title", "agenceNiort");
		String id = node.getIdentifier();

		session.save();
		//JCRPublicationService.getInstance().publishByMainId(id);
		
		
		
		//s.getJahiaSitesService().getSitesNames();

		
		System.out.println("In the action!");
		//System.out.println(renderContext.getSite().toString());
		//System.out.println(renderContext.get);
		//System.out.print
		//renderContext.getSite().getHome().addNode("agence_niort", "jnt:page");
		return new ActionResult(HttpServletResponse.SC_OK, "/sites/usineagences/home");
	}

}
