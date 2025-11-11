import com.viacep.challenge.api.BuscaCep;
import com.viacep.challenge.domain.Endereco;

import java.io.IOException;

public class CepBuscaMainTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaCep buscaCep = new BuscaCep();
        buscaCep.menuCep();
    }
}
