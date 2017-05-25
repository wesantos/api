package br.com.r39.api.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.r39.dao.PessoaDAO;
import br.com.r39.erp.model.Pessoa;
import br.com.r39.erp.util.JPAUtil;

@Path("/pessoa")
public class PessoaResource {
	private EntityManager em = new JPAUtil().getEntityManager();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		em.getTransaction().begin();
		Pessoa pessoa = new Pessoa();
		pessoa = new PessoaDAO(em).localizar(1);
		em.close();
		return "nome:"
				+pessoa.getNome()
	  		+" email:"
				+pessoa.getEmail()
			+" observacao:"
				+pessoa.getObservacao();
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		em.getTransaction().begin();
		Pessoa pessoa = new Pessoa();
		pessoa = new PessoaDAO(em).localizar(1);
		em.close();
		return "<?xml version=\"1.0\"?>" + "<pessoa><nome:>"
		+pessoa.getNome()
  		+"</nome><email:>"
			+pessoa.getEmail()
		+"</email><observacao:>"
			+pessoa.getObservacao()+"</observacao></pessoa>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
	  return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	      + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
}
