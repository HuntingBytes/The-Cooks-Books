package com.cooksbooks;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.utils.Categoria;
import com.cooksbooks.utils.Custo;
import com.cooksbooks.utils.Dificuldade;
import com.cooksbooks.utils.ExperienciaCulinaria;
import com.cooksbooks.utils.Ingrediente;
import com.cooksbooks.utils.TempoPreparo;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Classe feita para uso interno, não deve ser instanciada
 * e nem utilizada em outras partes do código.
 * <p>
 * Aqui serão realizados testes envolvendo os CRUD's.
 * </p>
 * <p>
 * Inicialmente, iremos demonstrar o cadastro de
 * um novo usuário, o cadastro de um novo caderno,
 * um cadastro de uma nova receita.
 * </p>
 * <p>
 * Também iremos demonstrar algumas atualizações
 * simples nas classes que possuem repositório.
 * </p>
 * @since 25-01-2021
 */
public final class TesteCRUDS {
  private TesteCRUDS() {}

  public static void main(String[] args) {

    // Obtendo uma instância do sistema (fachada)
    ICooksBooks sistema = CooksBooksFachada.getInstancia();
    boolean jaLogado = false;

    // Tentativa de efetuar login
    if(!sistema.efetuarLogin("user", "password")) {
      System.out.println("Não foi possível realizar o login. Favor checar os campos e tentar novamente.");
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm");
      System.out.println("Usuário logado!");
      System.out.printf("Bem vindo, %s!\n", sistema.getUsuarioLogado().getNomePerfil());
      System.out.printf("Sua conta foi criada em: %s.\n",
                        formatter.format(sistema.getUsuarioLogado().getDataCriacao()));
      System.out.printf("Sua biografia é: %s\n",sistema.getUsuarioLogado().getBiografia());
      jaLogado = true;
    }

    // Tentativa de criar uma conta com os dados acima
    Usuario usuario = new Usuario("user", "password");
    usuario.setNomePerfil("Usuário");
    usuario.setBiografia("Apenas um usuário de teste!");
    usuario.setExperienciaCulinaria(ExperienciaCulinaria.INICIANTE);
    sistema.cadastrarUsuario(usuario);

    // Tentativa de efetuar login novamente
    if(!jaLogado && sistema.efetuarLogin("user", "password")) {
      System.out.println("Usuário logado!");
      System.out.printf("Bem vindo, %s!\n", sistema.getUsuarioLogado().getNomePerfil());
      jaLogado = true;
    }

    // Tentativa de criar um novo caderno para o usuario logado
    CadernoReceitas meuCaderno =  new CadernoReceitas();
    meuCaderno.setNomeCaderno("Caderno para Festas");
    meuCaderno.setInformacoesCaderno("Caderno com várias receitas que podem ser usadas em festas!");

    sistema.cadastrarCaderno(meuCaderno);

    // Tentativa de criar uma nova receita para o caderno que foi cadastrado

    Receita minhaReceita = new Receita();
    minhaReceita.setTitulo("Brigadeiro");
    Ingrediente leiteCondensado = new Ingrediente("Leite condensado", 1, 7.5);
    Ingrediente achocolatado = new Ingrediente("Nescau ou Tody", 1, 5.0);
    minhaReceita.adicionarIngrediente(leiteCondensado);
    minhaReceita.adicionarIngrediente(achocolatado);
    minhaReceita.setCusto(Custo.BARATO);
    minhaReceita.setDificuldade(Dificuldade.FACIL);
    minhaReceita.setTempoPreparo(TempoPreparo.RAPIDO);
    minhaReceita.adicionarCategoria(Categoria.DOCE);
    minhaReceita.setModoPreparo("Coloca tudo dentro de uma panela, ligar o fogo e mexer bastante.");
    sistema.cadastrarReceita(minhaReceita, meuCaderno.getIdCaderno());

    System.out.println();

    // Listando todos os cadernos e receitas do usuários logado
    List<CadernoReceitas> cadernos = sistema.buscarTodosCadernosDoUsuarioAtual();
    System.out.printf("Esses são os cadernos e receitas de %s:\n", sistema.getUsuarioLogado().getNomePerfil());
    for(CadernoReceitas caderno : cadernos) {
      System.out.printf("%s: %s\n", caderno.getNomeCaderno(), caderno.getInformacoesCaderno());
      List<Receita> receitas = sistema.listarReceitasDoCaderno(caderno.getIdCaderno());
      for(Receita receita : receitas) {
        System.out.println("-".repeat(50));
        System.out.printf("%s", receita);
        System.out.println("-".repeat(50));
      }
    }

    // Fazendo alteração em um dos cadernos e umas das receitas
    sistema.alterarNomeCaderno(meuCaderno.getIdCaderno(), "Doces de Festa");
    sistema.alterarInformacoesCaderno(meuCaderno.getIdCaderno(), "Caderno com doces que podem ser usadas em festas!");
    sistema.alterarTitulo(minhaReceita.getIdReceita(), "Brigadeiro de Festa");

    System.out.println();

    cadernos = sistema.buscarTodosCadernosDoUsuarioAtual();
    System.out.printf("Esses são os cadernos e receitas de %s após a atualização:\n", sistema.getUsuarioLogado().getNomePerfil());
    for(CadernoReceitas caderno : cadernos) {
      System.out.printf("%s: %s\n", caderno.getNomeCaderno(), caderno.getInformacoesCaderno());
      List<Receita> receitas = sistema.listarReceitasDoCaderno(caderno.getIdCaderno());
      for(Receita receita : receitas) {
        System.out.println("-".repeat(50));
        System.out.printf("%s", receita);
        System.out.println("-".repeat(50));
      }
    }
  }
}
