package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropondoLanceSteps {

    private Lance lance;

    private Leilao leilao;
    private ArrayList<Lance> lista;

    @Before
    public void setUp() {
        this.lista = new ArrayList<Lance>();
        leilao = new Leilao("Tablet XPTO");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
        leilao = new Leilao("Tablet XPTO");
    }

    @Quando("propoe ao leilao")
    public void quando_propoe_ao_leilao() {
        leilao = new Leilao("Tablet XPTO");
        leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }


    @Dado("um lance de {double} reais do usuário {string}")
    public void um_lance_de_reais_do_usuário_fulano(Double valor, String nomeDoUsuario) {
        Lance lance = new Lance(new Usuario(nomeDoUsuario), new BigDecimal(valor));
        lista.add(lance);
    }

    @Quando("propoe vários lances ao leilao")
    public void propoe_vários_lances_ao_leilao() {
        this.lista.forEach(lance -> leilao.propoe(lance));
    }

    @Entao("os lances são aceitos")
    public void os_lances_são_aceitos() {
        Assert.assertEquals(this.lista.size(), leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Dado("um lance inválido de {double} reais e nome do usuário {string}")
    public void um_lance_inválido_de_reais(Double valor, String nomeDoUsuario) {
        this.lance = new Lance(new BigDecimal(valor));
        System.out.println(nomeDoUsuario);
    }

    @Entao("o lance não é aceito")
    public void o_lance_não_é_aceito() {
        Assert.assertEquals(0, leilao.getLances().size());
//        System.out.println(leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<String> valores = dataTable.asList();
        for (String string : valores){
            System.out.println(string);
        }

    }

    @Entao("o segundo lance não é aceito")
    public void o_segundo_lance_não_é_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
    }


}