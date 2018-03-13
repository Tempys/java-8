package effective3.classes;

import java.util.*;

public  class Favorites {

    private Map<Class<?>,Object> map = new HashMap<>();

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }


    private Favorites(){}

    public  <T> void setFavorite(T value){
        //jects.requireNonNull()


    }


    public static void main(String[] args) {

        List<? super Number> s = new ArrayList<>();
        s.add(1);
        s.add(2L);
        s.add(3d);
      new String().getClass().asSubclass()

         new Favorites().setFavorite(new Integer(1));
    }
}
