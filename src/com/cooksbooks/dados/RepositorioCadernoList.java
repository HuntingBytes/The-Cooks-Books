package com.cooksbooks.dados;

import com.cooksbooks.dados.interfaces.IRepositorioCaderno;
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
  private final List<CadernoReceitas> cadernosSist;

  private RepositorioCadernoList() {
    this.cadernosSist = new ArrayList<>();
  }

  public static RepositorioCadernoList getInstancia() {
    if (RepositorioCadernoList.getInstancia() == null) {
      RepositorioCadernoList.instancia = RepositorioCadernoList.lerArquivo();
    }
    return RepositorioCadernoList.instancia;
  }

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

  @Override
  public void cadastrarCaderno(CadernoReceitas caderno) {
    this.cadernosSist.add(caderno);
  }

  @Override
  public void removerCaderno(String idCaderno) {
    this.cadernosSist.removeIf(caderno -> caderno.getIdCaderno().equals(idCaderno));
  }

  @Override
  public boolean existeCaderno(String idCaderno) {
    for (CadernoReceitas caderno : this.cadernosSist) {
      if (caderno.getIdCaderno().equals(idCaderno)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    for (CadernoReceitas caderno : this.cadernosSist) {
      if (caderno.getIdCaderno().equals(idCaderno)) {
        return caderno;
      }
    }
    return null;
  }

  @Override
  public List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario) {
    List<CadernoReceitas> cadernosDoUsuario = new ArrayList<>();
    for (CadernoReceitas caderno : this.cadernosSist) {
      if (caderno.getIdDono().equals(nomeUsuario)) {
        cadernosDoUsuario.add(caderno);
      }
    }
    return cadernosDoUsuario;
  }

  @Override
  public long quantidadeCadernosCadastrados() {
    return this.cadernosSist.size();
  }

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

  @Override
  public void alterarNomeCadernoExistente(String idCadernoSubstituido, String nomeCadernoNovo) {
    for (CadernoReceitas cadernoIdentificar : cadernosSist) {
      if (cadernoIdentificar.getIdCaderno().equals(idCadernoSubstituido)) {
        cadernoIdentificar.setNomeCaderno(nomeCadernoNovo);
      }
    }
  }

  @Override
  public void alterarinformacoesCadernoExistente(String idCadernoSubstituido,
      String informacoesCadernoNovo) {
    for (CadernoReceitas cadernoIdentificar : cadernosSist) {
      if (cadernoIdentificar.getIdCaderno().equals(idCadernoSubstituido)) {
        cadernoIdentificar.setInformacoesCaderno(informacoesCadernoNovo);
      }
    }

  }

  @Override
  public void alterarCadernoPublicoExistente(String idCadernoSubstituido) {
    for (CadernoReceitas cadernoIdentificar : cadernosSist) {
      if (cadernoIdentificar.getIdCaderno().equals(idCadernoSubstituido)) {
        cadernoIdentificar.setCadernoPublico(!cadernoIdentificar.isCadernoPublico());
      }
    }
  }
}
