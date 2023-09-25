package modulos.alergias;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import telas.AlergiaTela;
import telas.LoginTela;
import java.util.concurrent.TimeUnit;

public class AlergiaTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Cadastrar uma alergia corretamente")
    public void testCadastrarUmExame(){
        AlergiaTela alergiaTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoAlergia()
                .btnAlergiaRespiratoria()
                .btnAsma();
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}