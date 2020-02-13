package padraostrategy;


import java.util.List;
import padraostrategy.LeituraRetorno;


public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;
    
   
    public void processar(String nomeArquivo){
   List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
   
   for(Boleto b:boletos){
       System.out.println(b.toString());
   }
    }


    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
    
    
    
    
}
