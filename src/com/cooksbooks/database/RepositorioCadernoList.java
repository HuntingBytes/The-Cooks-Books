package com.cooksbooks.database;

import com.cooksbooks.database.interfaces.IRepositorioCaderno;
import com.cooksbooks.entity.CadernoReceitas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCadernoList implements IRepositorioCaderno, Serializable {

  @Serial
  private static final long serialVersionUID = 6039699407286777005L;
  private static RepositorioCadernoList instancia = null;

  private final List<CadernoReceitas> cadernosList;

  /**
   * Construtor privado do repositório que inicializa o ArrayList de cadernos
   */
  private RepositorioCadernoList() {
    this.cadernosList = new ArrayList<>();
  }

  /**
   * Método responsável por retornar a instância única do Repositorio dos Cadernos (Singleton)
   * <p>
   * Caso ela ainda não exista, uma nova instância será criada e retornada
   *
   * @return instancia do Repositorio dos Cadernos
   */
  public static RepositorioCadernoList getInstancia() {
    if (RepositorioCadernoList.instancia == null) {
      RepositorioCadernoList.instancia = RepositorioCadernoList.lerArquivo();
    }
    return RepositorioCadernoList.instancia;
  }

  /**
   * Método responsável por salvar o repositorio em um arquivo
   */
  @Override
  public void salvarArquivo() {
    if (RepositorioCadernoList.instancia == null) {
      return;
    }
    File out = new File("cadernos.dat");
    FileOutputStream fos;
    ObjectOutputStream oos = null;

    try {
      fos = new FileOutputStream(out);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(RepositorioCadernoList.instancia);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          /* Silent */
        }
      }
    }
  }
  
  /**
   * Método responsável por ler um  arquivo ja existente
   * <p>
   * tenta ler o um arquivo, caso nao exista ele cria um
   *
   * @return repositorio de cadernos que estava no arquivo que ele leu
   */
  private static RepositorioCadernoList lerArquivo() {
    RepositorioCadernoList instanciaLocal;

    File in = new File("cadernos.dat");
    FileInputStream fis;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(in);
      ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      instanciaLocal = (RepositorioCadernoList) o;
    } catch (Exception e) {
      instanciaLocal = new RepositorioCadernoList();
    } finally {
      if (ois != null) {
        try {
          ois.close();
        } catch (IOException e) {/* Silent exception */
        }
      }
    }
    return instanciaLocal;
  }

  /**
   * Método responsável por cadastrar um caderno no repositorio(ja foi verificado se esse caderno é
   * valido la no controlador)
   *
   * @param caderno caderno a ser adicionado ao repositorio
   */
  @Override
  public void cadastrarCaderno(CadernoReceitas caderno) {
    this.cadernosList.add(caderno);
  }

  /**
   * Método responsável por remover um caderno do repositorio
   *
   * @param idCaderno caderno a ser removido do repositorio
   */
  @Override
  public void removerCaderno(String idCaderno) {
    this.cadernosList.removeIf(caderno -> caderno.getIdCaderno().equals(idCaderno));
  }

  /**
   * Método responsável por verificar se existe um caderno no repositorio
   *
   * @param idCaderno id do caderno a ser procurado no repositorio
   * @return se existe ou nao o caderno procurado
   */
  @Override
  public boolean existeCaderno(String idCaderno) {
    for (CadernoReceitas caderno : this.cadernosList) {
      if (caderno.getIdCaderno().equals(idCaderno)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Método responsável por buscar um caderno no repositorio
   *
   * @param idCaderno id do caderno a ser procurado no repositorio
   * @return caderno que estava procurando, se nao existir ele retorna null
   */
  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    for (CadernoReceitas caderno : this.cadernosList) {
      if (caderno.getIdCaderno().equals(idCaderno)) {
        return caderno;
      }
    }
    return null;
  }

  /**
   * Método responsável por alterar o nome de um caderno ja existente no repositorio
   *
   * @param idCadernoSubstituido id do caderno que devemos substituir o nome
   * @param nomeCadernoNovo      nome do caderno que o usuario deseja atualizar, verificaçao feita
   *                             se o nome é valido no controlador
   */
  @Override
  public void alterarNomeCaderno(String idCadernoSubstituido, String nomeCadernoNovo) {
    CadernoReceitas cadernoReceitas = this.buscarCaderno(idCadernoSubstituido);
    cadernoReceitas.setNomeCaderno(nomeCadernoNovo);
  }

  /**
   * Método responsável por alterar as informaçoes de um caderno ja existente no repositorio
   *
   * @param idCadernoSubstituido   id do caderno que devemos substituir as informaçoes
   * @param informacoesCadernoNovo informaçoes do caderno que o usuario deseja atualizar,
   *                               verificaçao feita se as informaçaoes é valido no controlador
   */
  @Override
  public void alterarInformacoesCaderno(String idCadernoSubstituido,
      String informacoesCadernoNovo) {
    CadernoReceitas cadernoReceitas = this.buscarCaderno(idCadernoSubstituido);
    cadernoReceitas.setInformacoesCaderno(informacoesCadernoNovo);
  }

  /**
   * Método responsável por alterar a visibilidade de um caderno ja existente
   *
   * @param idCadernoSubstituido id do caderno que vamos alterar a visibilidade
   */
  @Override
  public void alterarVisibildadeCaderno(String idCadernoSubstituido, boolean visibilidade) {
    CadernoReceitas cadernoReceitas = this.buscarCaderno(idCadernoSubstituido);
    cadernoReceitas.setCadernoPublico(visibilidade);
  }

  @Override
  public void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno) {
    int index = getIndex(idCaderno);
    this.cadernosList.set(index, novoCaderno);
  }

  /**
   * Método responsável por listar todos os cadernos de um usuario
   *
   * @param nomeUsuario nome do usuario que deseja listar todos os cadernos
   * @return lista de cadernos do usuario desejado no repositorio
   */
  @Override
  public List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario) {
    List<CadernoReceitas> cadernosDoUsuario = new ArrayList<>();
    for (CadernoReceitas caderno : this.cadernosList) {
      if (caderno.getIdDono().equals(nomeUsuario)) {
        cadernosDoUsuario.add(caderno);
      }
    }
    return cadernosDoUsuario;
  }

  /**
   * Método responsável por dizer qual a quantidade de cadernos cadastrados ate agora
   *
   * @return o tamanho do repositorio
   */
  @Override
  public long totalCadernosCadastrados() {
    return this.cadernosList.size();
  }

  private int getIndex(String idCaderno) {
    for (int i = 0; i < this.cadernosList.size(); i++) {
      if (this.cadernosList.get(i).getIdCaderno().equals(idCaderno)) {
        return i;
      }
    }
    return -1;
  }
}
