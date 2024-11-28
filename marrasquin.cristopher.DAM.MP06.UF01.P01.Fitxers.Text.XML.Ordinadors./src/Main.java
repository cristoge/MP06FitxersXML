import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class Main {
    private static final String FITXER_INDIVIDUAL = "Fitxers/ordinador.xml";
    private static final String FITXER_LLISTA = "Fitxers/ordinadors.xml";
    public static void main(String[] args) {
        File directory = new File("Fitxers");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        OrdinadorLogic ordinadorlogic = new OrdinadorLogic();
        try {
            Ordinador ordinador = new Ordinador(1, "Lenovo", "Thinkpad", 16, 256, "Intel Core i5-6200U");

            List<Ordinador> ordinadors = new ArrayList<>();
            ordinadors.add(ordinador);
            ordinadors.add(new Ordinador(2, "Apple", "MacBook Air", 16, 512, "M3"));

            ordinadorlogic.serializeOrdinador(ordinador, FITXER_INDIVIDUAL);
            ordinadorlogic.serializeOrdinadors(ordinadors, FITXER_LLISTA);

            Ordinador deserializedOrdinador = ordinadorlogic.deserializeOrdinador(FITXER_INDIVIDUAL);
            System.out.println("\nOrdinador deserialitzat des de fitxer XML:");
            System.out.println(deserializedOrdinador);

            List<Ordinador> deserializedOrdinadors = ordinadorlogic.deserializeOrdinadors(FITXER_LLISTA);
            System.out.println("\nLlista d'ordinadors deserialitzada des de fitxer XML:");
            for (Ordinador it : deserializedOrdinadors) {
                System.out.println(it);
            }
        }
        catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
}