package prueba;

public class Main {

    public static void main(String[] args) {
        Traductor traductor = TraductorFactory.createTraductor("español");
        System.out.println(traductor.traducirNumero(4));
        System.out.println(traductor.traducirNumero(2));
        Traductor traductor2 = TraductorFactory.createTraductor("ingles");
        System.out.println(traductor2.traducirNumero(4));
        System.out.println(traductor2.traducirNumero(2));
    }
}

class FabricaTraductorEspañol extends TraductorFactory {

    @Override
    public Traductor MetodoFabrica() {
        return new TraductorEspañol();
    }
}

class FabricaTraductorIngles extends TraductorFactory {

    @Override
    public Traductor MetodoFabrica() {
        return new TraductorIngles();
    }
}

abstract class Traductor {
    public abstract String traducirNumero(int numero);
}

class TraductorEspañol extends Traductor {

    public TraductorEspañol() {
        super();
    }
    @Override
    public String traducirNumero(int numero) {
        String s = null;
        if (numero==1) {
            s = "uno";
        }
        else if (numero==2) {
            s = "dos";
        }
        return s;
    }
}

abstract class TraductorFactory {

    public TraductorFactory() {
    }
    public abstract Traductor MetodoFabrica();
    public static Traductor createTraductor(String idioma) {
        Traductor traductor = null;
        if ("español".equals(idioma)) {
            traductor = new FabricaTraductorEspañol().MetodoFabrica();
        }
        if ("ingles".equals(idioma)) {
            traductor = new FabricaTraductorIngles().MetodoFabrica();
        }
        return traductor;
    }
}

class TraductorIngles extends Traductor {
    public TraductorIngles() {
        super();
    }
    @Override
    public String traducirNumero(int numero) {
        String s = null;
        switch (numero) {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break;
        }
        return s;
    }
}
