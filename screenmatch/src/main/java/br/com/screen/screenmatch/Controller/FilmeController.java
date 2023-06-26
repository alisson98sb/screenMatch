package br.com.screen.screenmatch.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.screen.screenmatch.Main.filme.DadosCadastroFilme;
import br.com.screen.screenmatch.Main.filme.Filme;
import br.com.screen.screenmatch.Main.filme.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {
//	private List<Filme> filmes = new ArrayList<>();
	@Autowired
	private FilmeRepository repository;
	
	@GetMapping("/formulario")
	public String carregaPaginaFormulário() {
		return "filmes/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("lista", repository.findAll());
		
		return "filmes/listagem";
	}
	
	@PostMapping
	public String cadastraFilme(DadosCadastroFilme dados, Model model) {
		var filme = new Filme(dados);
		repository.save(filme);
		
		/* model.addAttribute("lista", filmes); return "filmes/listagem";*/
		
		return "redirect:/filmes";
	}
}
