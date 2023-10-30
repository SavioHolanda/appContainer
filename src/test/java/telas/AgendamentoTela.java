package telas;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AgendamentoTela {
    private AndroidDriver app;

    public AgendamentoTela(AndroidDriver app) {
        this.app = app;
    }

 /*   public AgendamentoTela botaoMeusAgendamentos(){
        return this;
    }*/

    public AgendamentoTela selecaoTipoAgendamento(String tipoAgendamento) {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")).click();
        List<WebElement> elements = app.findElements(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
        for (WebElement element : elements) {
            if (element.getText().equals(tipoAgendamento)) {
                element.click();
            }else{

            }
        }

        return this;
    }

    public AgendamentoTela botaoOk() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[4]")).click();
        return this;
    }

    public AgendamentoTela btnVoltar(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[3]")).click();
        return this;
    }

    public String txtAgendamento() {
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }

    public String txtMeusAgendamentos(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText();
    }

    public AgendamentoTela btnCancelar() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        return this;
    }

    public AgendamentoTela selecionarDataDisponivel() {
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[41]/android.view.ViewGroup/android.widget.TextView")).click();
        return this;
    }

    public AgendamentoTela botaoOKAgenda(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[43]")).click();
        return this;
    }

    public AgendamentoTela selecionarHora(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
        return this;
    }

    public AgendamentoTela confirmarAgendamento(){
        app.findElement(By.id("android:id/button2")).click();
        return this;
    }

    public AgendamentoTela naoConfirmarAgendamento(){
        app.findElement(By.id("android:id/button1")).click();
        return this;
    }

    public String mensagemSucessoAgendamento(){
         return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }

    public String mensagemSucessoAgendamento2(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }

    public String mensagemAtencao(){
        return app.findElement(By.id("android:id/alertTitle")).getText();
    }

    public String mensagemTipoAgendamenot(){
        return app.findElement(By.id("android:id/message")).getText();
    }
    public String txtselecioneDia(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView")).getText();
    }

    public AgendamentoTela btnAgendaVoltar(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[42]")).click();
        return this;
    }

    public String txtTipoAgendamento(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }

    public String txthoraAgendamento(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")).getText();
    }
}