
package conecta4;


import conecta4.juego.MenuInicio;

public class MainC4 {
    MenuInicio menu = new MenuInicio();

    public MainC4() {
        int resultado;

        do {
            resultado = menu.ejecutarMenuInicio();
        } while (resultado == 0);

    }
}
