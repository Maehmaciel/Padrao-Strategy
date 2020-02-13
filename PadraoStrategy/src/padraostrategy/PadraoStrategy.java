
package padraostrategy;

public class PadraoStrategy {

   
    public static void main(String[] args) {
        
        String nomeArquivoBradesco = "bradesco-1.csv";
         String nomeArquivoBB = "banco-brasil-1.csv";
        LeituraRetornoBradesco bradesco=new LeituraRetornoBradesco();
        LeituraRetornoBancoBrasil bb=new LeituraRetornoBancoBrasil();
        
        ProcessarBoletos pb = new ProcessarBoletos();
        
        
       pb.setLeituraRetorno(bradesco);
        pb.processar(nomeArquivoBradesco);
        System.out.println("\n\n\n\n\n");
        pb.setLeituraRetorno(bb);
        pb.processar(nomeArquivoBB);
       
        
    
    }
    
}
