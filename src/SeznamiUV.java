import java.util.Scanner;
import java.util.HashMap;

public class SeznamiUV {

    HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;

    public SeznamiUV() {
        seznami = new HashMap<>();
        seznami.put("pv", new PrioritetnaVrsta<>());
        seznami.put("sk", new Sklad<>());
        seznami.put("bst", new Bst<>());
        seznami.put("d23", new Bst<>());
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token;
        String result = "OK";
        if (sc.hasNext()) {
            token = sc.next();
        } else {
            return "Error: enter command";
        }
        if (!token.equals("use") && (null == seznam)) {
            return "Error: please specify a data structure (use {pv|sk|bst|d23})";
        }
        try {
            switch (token) {
                case "use":
                    if (sc.hasNext()) {
                          seznam = seznami.get(sc.next());
                        if (null == seznam) {
                            result = "Error: please specify a correct data structure type {pv|sk|bst|d23}";
                        }
                    } else {
                        result = "Error: please specify a data structure type {pv|sk|bst|d23}";
                    }
                    break;
                case "add":
                    if (sc.hasNext()) {
                        seznam.add(sc.next());
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                case "remove_first":
                    result = seznam.removeFirst();
                    break;
                case "getfirst":
                    result = seznam.getFirst();
                    break;
                case "size":
                    result = seznam.size() + "";
                    break;
                case "depth":
                    result = seznam.depth() + "";
                    break;
                case "is_empty":
                    result = "Data structure is " + (seznam.isEmpty() ? "" : "not ") + "empty.";
                    break;
                case "reset":
                    while (!seznam.isEmpty()) {
                        seznam.removeFirst();
                    }
                    break;
                case "exists":
                    if (sc.hasNext()) {
                        result = "Element " + (seznam.exists(sc.next()) ? "exists " : "doesn't exist ") + "in data structure.";
                        
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                case "remove":
                    if (sc.hasNext()) {
                        result = seznam.remove(sc.next());
                    } else {
                        result = "Error: please specify a string";
                    }
                    break;
                
                default:
                    result = "Error: invalid command";
            }
        } catch (IllegalArgumentException e) {
            result = "Error: Duplicated entry";
        } catch (java.util.NoSuchElementException e) {
            result = "Error: data structure is empty";
        }

        return result;
    }

}
