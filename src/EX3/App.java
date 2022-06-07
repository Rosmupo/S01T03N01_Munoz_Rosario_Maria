package EX3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        //Método que lee el ARCHIVO txt y guarda los datos en un Hashmap.
        HashMap<String, String> countries = fillListCountries();
        //El jugador contesta a las 10 preguntas
        Player playerPlay = play(countries);
        //Se escribe un archivo txt con el nombre del jugador y su puntuación
        writeFileClasification(playerPlay);

    }
    ////////// FUNCIONES
    private static HashMap<String, String> fillListCountries() {
        HashMap<String, String> countries = new HashMap<>();
        try {
            FileReader fileReader = new FileReader("/Users/Rosario/eclipse-workspace/S01T03N01_Munoz_Rosario/src/EX3/Countries.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = " ";
            while ((line = bufferedReader.readLine()) != null) {
                String[] word = line.split(" ");
                    if (word.length != 1) {
                        String country = word[0];
                        String capital = word[1];
                        countries.put(country, capital);
                    }
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return countries;
    }

    private static Player play(HashMap<String, String> countries) {
        Player player = createPlayer();
        int score = 0;
        for (int i = 0; i < 10; i++) {
            String country = selectRandomCountry(countries);
            String capital = answer(country);
            score += checkAnswer(country, capital, countries);
        }
        player.setScore(score);

        return player;
    }

    private static Player createPlayer() {
        Player player = new Player(askString("Indique su nombre"));
        return player;
    }

    private static String selectRandomCountry(HashMap<String, String> countries) {
        List<String> countryList = new ArrayList<String>(countries.keySet());
        int randomIndex = new Random().nextInt(countryList.size());
        String randomCountry = countryList.get(randomIndex);
        countryList.remove(randomIndex);
        return randomCountry;
    }

    private static String answer(String randomCountry) {
        String capital = askString("Indique la capital del país " + randomCountry);
        return capital;
    }

    private static int checkAnswer(String country, String capital, HashMap<String, String> countries) {
        int score;
        if (countries.get(country).equalsIgnoreCase(capital)) {
            System.out.println("Respuesta correcta, ha sumado un punto");
            score = 1;
        } else {
            score = 0;
            System.out.println("Respuesta incorrecta");
        }
        return score;
    }

    private static void writeFileClasification(Player player) throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/Rosario/eclipse-workspace/S01T03N01_Munoz_Rosario/src/EX3/Clasification.txt");
        fileWriter.write("Nombre del jugador: " + player.getName() + ". Puntación:" +player.getScore()+ ".");
        fileWriter.close();
    }

    ////////// ENTRADA DATOS
    private static String askString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
}
