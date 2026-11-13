package br.com.umc.produtos.controller;

import br.com.umc.produtos.model.Produto;
import br.com.umc.produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("produtos", service.buscarPorNome(busca));
        model.addAttribute("busca", busca == null ? "" : busca);
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("titulo", "Cadastrar produto");
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") Produto produto,
                         BindingResult resultado,
                         Model model,
                         RedirectAttributes redirect) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", produto.getId() == null
                    ? "Cadastrar produto" : "Editar produto");
            return "produtos/formulario";
        }

        service.salvar(produto);
        redirect.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("produto", service.buscarPorId(id));
        model.addAttribute("titulo", "Editar produto");
        return "produtos/formulario";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        service.excluir(id);
        redirect.addFlashAttribute("sucesso", "Produto excluído com sucesso!");
        return "redirect:/produtos";
    }
}
