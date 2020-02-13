package padraostrategy;


import padraostrategy.Boleto;
import java.util.List;

public interface LeituraRetorno {
    public List<Boleto> lerArquivo(String nomeArquivo);
}
