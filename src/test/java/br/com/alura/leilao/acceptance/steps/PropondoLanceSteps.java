package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Lance lance10;
    private Lance lance15;
    private Leilao leilao;

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

    @Dado("vários lances válidos")
    public void vários_lances_válidos() {
        Usuario usuario1 = new Usuario("fulano");
        lance10 = new Lance(usuario1, BigDecimal.TEN);
        Usuario usuario2 = new Usuario("beltrano");
        lance15 = new Lance(usuario2, new BigDecimal("15.0"));
        leilao = new Leilao("Tablet XPTO");
    }

    @Quando("propoe vários lances ao leilao")
    public void propoe_vários_lances_ao_leilao() {
        leilao.propoe(lance10);
        leilao.propoe(lance15);

    }

    @Entao("os lances são aceitos")
    public void os_lances_são_aceitos() {
        Assert.assertEquals(2, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
        Assert.assertEquals(new BigDecimal ("15.0"), leilao.getLances().get(1).getValor());
    }

}
