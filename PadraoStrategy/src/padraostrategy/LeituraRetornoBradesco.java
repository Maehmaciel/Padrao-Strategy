package padraostrategy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import padraostrategy.LeituraRetorno;
import padraostrategy.Boleto;
import java.util.ArrayList;
import java.util.List;
import static padraostrategy.LeituraRetornoBancoBrasil.FORMATO_DATA;

public class LeituraRetornoBradesco implements LeituraRetorno{
    
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("Arquivo do Bradesco");
            try {
          List<Boleto> boletos = new ArrayList();
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);

                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(0, 0, 0));

                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }  
    
    }
    
}
