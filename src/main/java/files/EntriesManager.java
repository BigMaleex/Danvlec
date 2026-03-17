package files;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import user.LocalEntry;

import java.io.*;
import java.nio.file.Files; // Agregado
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream; // Agregado

public class EntriesManager extends FileManager {

    private final Path entriesFolder;
    private final Gson gson;

    public EntriesManager() {
        super("Maleex Team", "Danvlec");

        this.entriesFolder = projectFolder.resolve("Entries");
        ensureFolderExists(entriesFolder);

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                        new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                        LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .create();
    }

    public void saveLocalEntry(LocalEntry newEntry) {
        String fileName = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        File jsonFile = entriesFolder.resolve(fileName + ".json").toFile();

        List<LocalEntry> entryList = getEntriesFromFile(jsonFile.toPath());
        entryList.add(newEntry);

        try (Writer writer = new FileWriter(jsonFile)) {
            gson.toJson(entryList, writer);
            System.out.println("✔ Entrada guardada exitosamente en: " + jsonFile.getName());
        } catch (IOException e) {
            System.err.println("✘ Error al escribir el JSON: " + e.getMessage());
        }
    }

    public int getTotalCount() {
        try (Stream<Path> paths = Files.list(entriesFolder)) {
            return paths
                    .filter(path -> path.toString().endsWith(".json"))
                    .mapToInt(path -> getEntriesFromFile(path).size())
                    .sum();
        } catch (IOException e) {
            return 0;
        }
    }

    public int getMonthCount() {
        return getAllEntriesFromMonth(LocalDateTime.now()).size();
    }

    public int getWeekCount() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sevenDaysAgo = now.minusDays(7);
        int count = 0;

        List<LocalEntry> entries = new ArrayList<>();
        entries.addAll(getAllEntriesFromMonth(now));

        if (now.getDayOfMonth() < 8) {
            entries.addAll(getAllEntriesFromMonth(now.minusMonths(1)));
        }

        for (LocalEntry entry : entries) {
            if (entry.getDate().isAfter(sevenDaysAgo) || entry.getDate().isEqual(sevenDaysAgo)) {
                count++;
            }
        }
        return count;
    }

    private List<LocalEntry> getAllEntriesFromMonth(LocalDateTime date) {
        String fileName = date.format(DateTimeFormatter.ofPattern("yyyy-MM"));
        Path path = entriesFolder.resolve(fileName + ".json");
        return getEntriesFromFile(path);
    }

    private List<LocalEntry> getEntriesFromFile(Path path) {
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(path.toFile())) {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<LocalEntry>>() {}.getType();
            List<LocalEntry> data = gson.fromJson(reader, listType);
            return (data != null) ? data : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error al leer: " + path.getFileName());
            return new ArrayList<>();
        }
    }

    public List<LocalEntry> getAllEntries() {
        List<LocalEntry> all = new ArrayList<>();
        try (Stream<Path> paths = Files.list(entriesFolder)) {
            paths.filter(path -> path.toString().endsWith(".json"))
                 .forEach(path -> all.addAll(getEntriesFromFile(path)));
        } catch (IOException e) {
            System.err.println("✘ Error al leer las entradas: " + e.getMessage());
        }
        return all;
    }

}